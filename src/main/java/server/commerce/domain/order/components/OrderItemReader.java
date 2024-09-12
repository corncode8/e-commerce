package server.commerce.domain.order.components;

import static server.commerce.api.support.response.BaseResponseStatus.NOT_FOUND_ORDER;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
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
