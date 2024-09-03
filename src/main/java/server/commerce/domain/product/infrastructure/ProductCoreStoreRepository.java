package server.commerce.domain.product.infrastructure;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductCoreStoreRepository {

	private final ProductJpaRepository productJpaRepository;
}
