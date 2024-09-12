package server.commerce.domain.payment.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.service.OrderService;
import server.commerce.domain.payment.service.DataSendService;
import server.commerce.domain.product.service.ProductService;
import server.commerce.domain.product.service.StockService;

@Component
@RequiredArgsConstructor
public class PaymentEventListener {

	private final DataSendService dataSendService;
	private final ProductService productService;
	private final OrderService orderService;
	private final StockService stockService;

	@Async
	@EventListener
	public void paymentSuccessHandler(PaymentSuccessEvent event) {
		dataSendService.send(event.getOrder());
		productService.updateProductStock(event.getOrder());
	}

	@Transactional
	public void paymentFailedHandler(PaymentFailEvent event) {
		orderService.failOrder(event.getOrder());
		stockService.compensateStock(event.getOrder());
	}
}
