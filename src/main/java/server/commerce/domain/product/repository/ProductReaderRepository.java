package server.commerce.domain.product.repository;

import java.util.List;
import java.util.Optional;

import server.commerce.domain.product.entity.Product;

public interface ProductReaderRepository {

	Product findById(Long productId);

	List<Product> readAll();
}
