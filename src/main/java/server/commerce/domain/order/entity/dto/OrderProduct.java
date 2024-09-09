package server.commerce.domain.order.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.commerce.domain.product.entity.Product;

@Data
@AllArgsConstructor
public class OrderProduct {
	private Long productId;
	private String productName;
	private Long unitPrice;
	private Long totalPrice;
	private Long quantity;

	public static OrderProduct of(Product product, Long quantity) {
		return new OrderProduct(
			product.getId(),
			product.getName(),
			product.getPrice(),
			product.orderTotalPrice(quantity),
			quantity);
	}
}
