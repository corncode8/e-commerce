package server.commerce.domain.order.event;

import lombok.Getter;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.payment.entity.Payment;

@Getter
public class OrderSuccessEvent {

	private final Order order;


	public OrderSuccessEvent(Order order) {
		this.order = order;
	}
}
