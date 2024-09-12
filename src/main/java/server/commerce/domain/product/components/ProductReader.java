package server.commerce.domain.product.components;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
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

	public List<Product> readTopSellingProducts() {
		LocalDateTime endDate = LocalDateTime.now();
		LocalDateTime startDate = endDate.minusDays(3);
		Pageable topFive = PageRequest.of(0,5);

		return productReaderRepository.findTopSellingProducts(Order.OrderStatus.ORDERED, startDate, endDate, topFive);
	}

	public List<Product> readAllByIds(List<Long> productIds) {
		return productReaderRepository.readAllByIds(productIds);
	}
}
