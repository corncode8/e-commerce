package server.commerce.api.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import server.commerce.api.dto.request.OrderRequest;
import server.commerce.domain.order.components.OrderManager;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.event.OrderEventPublisher;
import server.commerce.domain.order.event.OrderSuccessEvent;

@Service
@RequiredArgsConstructor
public class OrderUseCase {

	private final OrderManager orderManager;
	private final OrderEventPublisher eventPublisher;
	@Transactional
	public Order order(Long userId, OrderRequest request) {
		Order order = orderManager.order(userId, request);

		eventPublisher.eventPublish(new OrderSuccessEvent(order));

		return order;
	}
}
