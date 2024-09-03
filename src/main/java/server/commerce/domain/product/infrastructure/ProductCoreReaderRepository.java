package server.commerce.domain.product.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.repository.ProductReaderRepository;

@Repository
@RequiredArgsConstructor
public class ProductCoreReaderRepository implements ProductReaderRepository {

	private final ProductJpaRepository productJpaRepository;

	public Optional<Product> findById(Long productId) {
		return productJpaRepository.findById(productId);
	}

	public List<Product> readAll() {
		return productJpaRepository.findAll();
	}

}
