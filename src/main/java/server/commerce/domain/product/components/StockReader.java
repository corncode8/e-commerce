package server.commerce.domain.product.components;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.product.entity.Stock;
import server.commerce.domain.product.repository.StockRepository;

@Component
@RequiredArgsConstructor
public class StockReader {

	private final StockRepository stockRepository;

	public Stock readByProductId(Long productId) {
		return stockRepository.findByProductId(productId);
	}
}
