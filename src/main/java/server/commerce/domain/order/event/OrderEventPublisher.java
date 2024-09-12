package server.commerce.domain.order.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	public void eventPublish(OrderSuccessEvent event) {
		applicationEventPublisher.publishEvent(event);
	}
}
