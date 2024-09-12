package server.commerce.domain.order.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import server.commerce.domain.order.entity.OrderItem;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findByOrderId(Long orderId);
}
