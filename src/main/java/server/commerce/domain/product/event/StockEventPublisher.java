package server.commerce.domain.product.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StockEventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	public void eventPublish(StockSuccessEvent event) {
		applicationEventPublisher.publishEvent(event);
	}

	public void eventPublish(StockFailEvent event) {
		applicationEventPublisher.publishEvent(event);
	}
}
