package server.commerce.domain.product.event;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.service.OrderService;
import server.commerce.domain.payment.service.PaymentService;
import server.commerce.domain.product.service.StockService;

@Component
@RequiredArgsConstructor
public class StockEventListener {

	private final PaymentService paymentService;
	private final OrderService orderService;
	private final StockService stockService;

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void stockDecreaseSuccessHandler(StockSuccessEvent event) {
		paymentService.pay(event.getOrder());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
	public void stockDecreaseFailedHandler(StockFailEvent event) {
		orderService.failOrder(event.getOrder());
		stockService.compensateStock(event.getOrder());
	}
}
