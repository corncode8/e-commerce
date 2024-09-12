package server.commerce.domain.order.infrastructure;

import static server.commerce.api.support.response.BaseResponseStatus.NOT_FOUND_ORDER;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.order.entity.dto.OrderForm;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.order.repository.OrderRepository;

@Repository
@RequiredArgsConstructor
public class OrderCoreRepository implements OrderRepository {

	private final OrderJpaRepository orderJpaRepository;
	private final OrderItemJpaRepository orderItemJpaRepository;

	@Override
	public Order create(Long userId, OrderForm orderForm) {
		Order order = orderJpaRepository.save(new Order(
			userId,
			orderForm.getPayAmount(),
			orderForm.getAddress(),
			orderForm.getReceiverName(),
			orderForm.getPhone(),
			Order.OrderStatus.READY
		));

		orderItemJpaRepository.saveAll(
			orderForm.getOrderProducts().stream()
				.map(p -> new OrderItem(
					order.getId(),
					p.getProductId(),
					p.getProductName(),
					p.getUnitPrice(),
					p.getTotalPrice(),
					p.getQuantity()
				)).collect(Collectors.toList()));

		return order;
	}

	@Override
	public Order findById(Long id) {
		return orderJpaRepository.findById(id)
			.orElseThrow(() -> new BaseException(NOT_FOUND_ORDER));
	}
}
