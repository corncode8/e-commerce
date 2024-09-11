package server.commerce.api.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import server.commerce.domain.product.entity.Product;

@Data
public class ProductListResponse {

	private List<ProductResponse> responseList;

	public ProductListResponse(List<Product> productList) {
		this.responseList = productList.stream()
			.map(ProductResponse::new)
			.collect(Collectors.toList());
	}
}
