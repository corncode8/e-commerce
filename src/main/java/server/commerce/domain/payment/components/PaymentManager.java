package server.commerce.domain.payment.components;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.payment.entity.Payment;
import server.commerce.domain.payment.repository.PaymentRepository;

@Component
@RequiredArgsConstructor
public class PaymentManager {

	private final PaymentRepository paymentRepository;

	public Payment create(Order order) {
		return paymentRepository.create(order.getId(), order.getPayAmount());
	}
}
