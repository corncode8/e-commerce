package server.commerce.domain.order.event;

import lombok.Getter;
import server.commerce.domain.order.entity.Order;

@Getter
public class OrderSuccessEvent {

	private final Order order;


	public OrderSuccessEvent(Order order) {
		this.order = order;
	}
}
