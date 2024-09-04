package server.commerce.domain.order.repository;

import server.commerce.domain.order.entity.OrderItem;

public interface OrderItemReaderRepository {

	OrderItem findById(Long orderItemId);
}
