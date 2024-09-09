package server.commerce.domain.product.repository;

import server.commerce.domain.product.entity.Stock;

public interface StockRepository {

	void updateStock(Stock stock);

	Stock findByProductId(Long productId);
}
