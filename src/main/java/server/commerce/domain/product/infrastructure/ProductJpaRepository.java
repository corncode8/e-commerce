package server.commerce.domain.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import server.commerce.domain.product.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
