package server.commerce.domain.product.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.order.repository.OrderItemReaderRepository;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.repository.ProductReaderRepository;

@Component
@RequiredArgsConstructor
public class ProductUpdator {

	private final ProductReaderRepository productReaderRepository;
	private final OrderItemReaderRepository orderItemReaderRepository;

	public void updateStock(Order order) {
		List<OrderItem> orderItems = new ArrayList<>();

		for (Long item : order.getOrderItemId()) {
			orderItems.add(orderItemReaderRepository.findById(item));
		}

		for (OrderItem item : orderItems) {
			Product product = productReaderRepository.findById(item.getProductId());
			product.decreaseStock(item.getQuantity());
		}

	}
}
