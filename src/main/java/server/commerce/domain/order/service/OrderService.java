package server.commerce.domain.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.components.OrderManager;
import server.commerce.domain.order.entity.Order;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderManager orderManager;

	@Transactional
	public void failOrder(Order order) {
		orderManager.failOrder(order);
	}
}
