package server.commerce.domain.product.components;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.product.entity.Stock;
import server.commerce.domain.product.repository.StockRepository;

@Component
@RequiredArgsConstructor
public class StockManager {

	private final StockReader stockReader;
	private final StockValidator stockValidator;
	private final StockRepository stockRepository;

	public void decreaseProductStock(OrderItem orderItem) {
		Stock stock = stockReader.readByProductId(orderItem.getProductId());
		stockValidator.checkStockQuantity(stock, orderItem);
		stock.decreaseStock(orderItem.getQuantity());
	}

	public Stock readByProductId(Long productId) {
		return stockRepository.findByProductId(productId);
	}

}
