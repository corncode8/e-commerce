package server.commerce.domain.product.components;

import org.springframework.stereotype.Component;

import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.product.entity.Stock;

@Component
public class StockValidator {

	public void checkStockQuantity(Stock stock, OrderItem orderItem) {
		stock.isEnoughStockQuantity(orderItem.getQuantity());
	}
}
