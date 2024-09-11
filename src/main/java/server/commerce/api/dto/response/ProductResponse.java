package server.commerce.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.commerce.domain.product.entity.Product;

@Data
@AllArgsConstructor
public class ProductResponse {
	private Long productId;
	private String name;
	private Long price;
	private Long stock;

	public ProductResponse(Product product) {
		this.productId = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.stock = product.getStockQuantity();
	}
}
