package server.commerce.domain.payment.event;

import lombok.Getter;
import server.commerce.domain.order.entity.Order;

@Getter
public class PaymentFailEvent {

	private final Order order;

	public PaymentFailEvent(Order order) {
		this.order = order;
	}
}
