package server.commerce.domain.product.event;

import lombok.Getter;
import server.commerce.domain.order.entity.Order;

@Getter
public class StockFailEvent {

	private final Order order;

	public StockFailEvent(Order order) {
		this.order = order;
	}
}
