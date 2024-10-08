package server.commerce.domain.payment.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentEventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	public void eventPublish(PaymentSuccessEvent event) {
		applicationEventPublisher.publishEvent(event);
	}

	public void eventPublish(PaymentFailEvent event) {
		applicationEventPublisher.publishEvent(event);
	}
}
