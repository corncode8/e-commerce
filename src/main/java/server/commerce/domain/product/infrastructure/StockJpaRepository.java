package server.commerce.domain.product.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import jakarta.persistence.LockModeType;
import server.commerce.domain.product.entity.Stock;

public interface StockJpaRepository extends JpaRepository<Stock, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Stock> findByProductId(Long productId);
}
