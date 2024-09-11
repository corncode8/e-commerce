package server.commerce.api.dto.response;

import lombok.Data;
import server.commerce.domain.order.entity.Order;

@Data
public class OrderResponse {

	private Long orderId;
	private Long userId;
	private Long payAmount;

	public OrderResponse(Order order) {
		this.orderId = order.getId();
		this.userId = order.getUserId();
		this.payAmount = order.getPayAmount();
	}
}
