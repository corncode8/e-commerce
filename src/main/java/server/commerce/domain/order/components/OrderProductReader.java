package server.commerce.domain.order.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.api.dto.request.ProductRequest;
import server.commerce.domain.order.entity.dto.OrderProduct;
import server.commerce.domain.product.components.ProductReader;

@Component
@RequiredArgsConstructor
public class OrderProductReader {

	private final ProductReader productReader;

	public List<OrderProduct> read(List<ProductRequest> productRequests) {
		List<OrderProduct> orderProducts = new ArrayList<>();
		productReader.readAllByIds(productRequests.stream().map(ProductRequest::getId).toList())
			.forEach(p -> {
				ProductRequest productRequest =
					productRequests.stream().filter(request -> p.getId().equals(request.getId())).findFirst().get();
				orderProducts.add(OrderProduct.of(p, productRequest.getQuantity()));
			});
		return orderProducts;
	}
}
