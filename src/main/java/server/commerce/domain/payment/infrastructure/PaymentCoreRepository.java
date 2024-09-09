package server.commerce.domain.payment.infrastructure;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.payment.entity.Payment;
import server.commerce.domain.payment.repository.PaymentRepository;

@Repository
@RequiredArgsConstructor
public class PaymentCoreRepository implements PaymentRepository {

	private final PaymentJpaRepository paymentJpaRepository;

	@Override
	public Payment create(Long orderId, Long payAmount) {
		Payment payment = new Payment(orderId, payAmount);
		return paymentJpaRepository.save(payment);
	}
}
