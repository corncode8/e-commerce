package server.commerce.domain.order.components;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.api.dto.request.OrderRequest;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.dto.OrderForm;
import server.commerce.domain.order.entity.dto.OrderProduct;
import server.commerce.domain.order.repository.OrderRepository;

@Component
@RequiredArgsConstructor
public class OrderManager {

	private final OrderRepository orderRepository;
	private final OrderProductReader orderProductReader;

	public Order order(Long userId, OrderRequest orderRequest) {
		List<OrderProduct> read = orderProductReader.read(orderRequest.getProductRequestList());
		OrderForm orderForm = OrderForm.of(orderRequest, read);
		return orderRepository.create(userId, orderForm);
	}
}
