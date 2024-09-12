package server.commerce.domain.product.event;

import lombok.Getter;
import server.commerce.domain.order.entity.Order;

@Getter
public class StockSuccessEvent {

	private final Order order;

	public StockSuccessEvent(Order order) {
		this.order = order;
	}
}
