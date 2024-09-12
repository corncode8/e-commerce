package server.commerce.domain.product.components;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.components.OrderItemReader;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.product.entity.Product;

@Component
@RequiredArgsConstructor
public class ProductManager {

	private final ProductReader productReader;
	private final OrderItemReader orderItemReader;

	public void updateProductStock(Order order) {
		List<OrderItem> orderItemList = orderItemReader.findByOrderId(order.getId());

		for (OrderItem item : orderItemList) {
			Product product = productReader.findById(item.getProductId());
			product.decreaseStock(item.getQuantity());
		}
	}
}
