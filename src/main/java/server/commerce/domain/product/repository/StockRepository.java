package server.commerce.domain.product.repository;

import server.commerce.domain.product.entity.Stock;

public interface StockRepository {

	Stock findByProductId(Long productId);
}
