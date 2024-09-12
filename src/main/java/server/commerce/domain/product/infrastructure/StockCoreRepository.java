package server.commerce.domain.product.infrastructure;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.api.support.response.BaseResponseStatus;
import server.commerce.domain.product.entity.Stock;
import server.commerce.domain.product.repository.StockRepository;

@Repository
@RequiredArgsConstructor
public class StockCoreRepository implements StockRepository {

	private final StockJpaRepository stockJpaRepository;

	@Override
	public Stock findByProductId(Long productId) {
		return stockJpaRepository.findByProductId(productId)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_STOCK))
			.toStock();
	}
}
