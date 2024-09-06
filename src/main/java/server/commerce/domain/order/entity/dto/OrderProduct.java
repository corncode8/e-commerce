package server.commerce.domain.order.entity.dto;

import lombok.Data;

@Data
public class OrderProduct {
	private Long productId;
	private String productName;
	private Long unitPrice;
	private Long totalPrice;
	private Long quantity;
}
