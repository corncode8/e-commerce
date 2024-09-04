package server.commerce.domain.product.infrastructure;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.product.repository.ProductStoreRepository;

@Repository
@RequiredArgsConstructor
public class ProductCoreStoreRepository implements ProductStoreRepository {

	private final ProductJpaRepository productJpaRepository;
}
