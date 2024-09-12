package server.commerce.domain.order.event;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.product.service.StockService;

@Component
@RequiredArgsConstructor
public class OrderSuccessEventListener {

	private final StockService stockService;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void orderSuccessHandler(OrderSuccessEvent event) {
		stockService.decreaseStock(event.getOrder());
	}
}
