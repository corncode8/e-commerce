package server.commerce.domain.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import server.commerce.domain.order.entity.Order;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
