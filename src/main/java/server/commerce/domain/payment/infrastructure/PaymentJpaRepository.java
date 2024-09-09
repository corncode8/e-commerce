package server.commerce.domain.payment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import server.commerce.domain.payment.entity.Payment;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
