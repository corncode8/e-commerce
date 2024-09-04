package server.commerce.domain.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import server.commerce.domain.order.entity.OrderItem;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Long> {
}
