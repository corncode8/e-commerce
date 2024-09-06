package server.commerce.domain.order.components;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.dto.OrderForm;
import server.commerce.domain.order.repository.OrderRepository;

@Component
@RequiredArgsConstructor
public class OrderManager {

	private final OrderRepository orderRepository;

	public Order order (Long userId, OrderForm orderForm) {
		return orderRepository.create(userId, orderForm);
	}
}
