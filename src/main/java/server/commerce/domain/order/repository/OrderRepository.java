package server.commerce.domain.order.repository;

import server.commerce.domain.order.entity.dto.OrderForm;
import server.commerce.domain.order.entity.Order;

public interface OrderRepository {

	Order create(Long userId, OrderForm orderForm);

	Order findById(Long id);
}
