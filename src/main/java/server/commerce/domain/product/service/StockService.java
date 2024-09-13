package server.commerce.domain.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import server.commerce.api.util.aop.DistributedLock;
import server.commerce.domain.order.components.OrderItemReader;
import server.commerce.domain.order.components.OrderManager;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.product.components.StockManager;
import server.commerce.domain.product.entity.Stock;
import server.commerce.domain.product.event.StockFailEvent;
import server.commerce.domain.product.event.StockSuccessEvent;
import server.commerce.domain.product.event.StockEventPublisher;

@Service
@RequiredArgsConstructor
public class StockService {

	private final StockManager stockManager;
	private final OrderItemReader orderItemReader;
	private final StockEventPublisher eventPublisher;
	public final OrderManager orderManager;


	@DistributedLock(key = "T(server.commerce.api.util.aop.LockType).DECREASE_STOCK.getKey(#order.id)")
	public void decreaseStock(Order order) {
		try {
			List<OrderItem> orderItemList = orderItemReader.findByOrderId(order.getId());

			for (OrderItem item : orderItemList) {
				stockManager.decreaseProductStock(item);
			}
			eventPublisher.eventPublish(new StockSuccessEvent(order));
		} catch (Exception e) {
			eventPublisher.eventPublish(new StockFailEvent(order));
		}
	}

	@Transactional
	public void compensateStock(Order order) {
		Order findOrder = orderManager.findOrder(order.getId());

		List<OrderItem> orderItemList = orderItemReader.findByOrderId(findOrder.getId());

		for (OrderItem item : orderItemList) {
			Stock stock = stockManager.readByProductId(item.getProductId());
			stock.increaseStock(item.getQuantity());
		}
	}


}
