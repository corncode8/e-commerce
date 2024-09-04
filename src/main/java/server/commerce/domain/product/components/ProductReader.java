package server.commerce.domain.product.components;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.repository.ProductReaderRepository;

@Component
@RequiredArgsConstructor
public class ProductReader {

	private final ProductReaderRepository productReaderRepository;

	public Product findById(Long productId) {
		return productReaderRepository.findById(productId);
	}

	public List<Product> readAll() {
		return productReaderRepository.readAll();
	}
}
