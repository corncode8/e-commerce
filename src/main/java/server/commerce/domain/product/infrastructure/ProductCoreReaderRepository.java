package server.commerce.domain.product.infrastructure;

import static server.commerce.api.support.response.BaseResponseStatus.NOT_FOUND_PRODUCT;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.repository.ProductReaderRepository;

@Repository
@RequiredArgsConstructor
public class ProductCoreReaderRepository implements ProductReaderRepository {

	private final ProductJpaRepository productJpaRepository;

	@Override
	public Product findById(Long productId) {
		return productJpaRepository.findById(productId)
			.orElseThrow(() -> new BaseException(NOT_FOUND_PRODUCT));
	}

	@Override
	public List<Product> readAll() {
		return productJpaRepository.findAll();
	}

}
