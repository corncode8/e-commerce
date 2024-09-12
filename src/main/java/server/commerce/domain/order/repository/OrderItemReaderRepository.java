package server.commerce.domain.order.repository;

import java.util.List;

import server.commerce.domain.order.entity.OrderItem;

public interface OrderItemReaderRepository {

	OrderItem findById(Long orderItemId);

	List<OrderItem> findByOrderId(Long orderId);
}
