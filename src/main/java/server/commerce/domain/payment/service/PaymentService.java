package server.commerce.domain.payment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.payment.components.PaymentManager;
import server.commerce.domain.payment.entity.Payment;
import server.commerce.domain.payment.event.PaymentEventPublisher;
import server.commerce.domain.payment.event.PaymentFailEvent;
import server.commerce.domain.payment.event.PaymentSuccessEvent;
import server.commerce.domain.user.components.UserPoint;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentManager paymentManager;
	private final UserPoint userPoint;
	private final PaymentEventPublisher eventPublisher;

	@Transactional
	public Payment pay(Order order) {
		try {
			userPoint.pointUse(order.getUserId(), order.getPayAmount());
			order.setOrdered();
			paymentManager.create(order);
			eventPublisher.eventPublish(new PaymentSuccessEvent(order));
		} catch (Exception e) {
			eventPublisher.eventPublish(new PaymentFailEvent(order));
		}

		return paymentManager.create(order);
	}
}
