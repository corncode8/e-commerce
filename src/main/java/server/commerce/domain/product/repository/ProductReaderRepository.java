package server.commerce.domain.product.repository;

import java.util.List;

import server.commerce.domain.product.entity.Product;

public interface ProductReaderRepository {

	Product findById(Long productId);

	List<Product> readAll();
}
