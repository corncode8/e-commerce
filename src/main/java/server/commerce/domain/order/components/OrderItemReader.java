package server.commerce.domain.order.components;


import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.order.repository.OrderItemReaderRepository;

@Component
@RequiredArgsConstructor
public class OrderItemReader {

	private final OrderItemReaderRepository repository;

	public List<OrderItem> findByOrderId(Long orderId) {
		return repository.findByOrderId(orderId);
	}
}
