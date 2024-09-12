package server.commerce.domain.payment.event;

import lombok.Getter;
import server.commerce.domain.order.entity.Order;

@Getter
public class PaymentSuccessEvent {

	private final Order order;

	public PaymentSuccessEvent(Order order) {
		this.order = order;
	}
}
