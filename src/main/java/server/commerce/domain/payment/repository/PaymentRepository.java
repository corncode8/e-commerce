package server.commerce.domain.payment.repository;

import server.commerce.domain.payment.entity.Payment;

public interface PaymentRepository {

	Payment create(Long orderId, Long payAmount);
}
