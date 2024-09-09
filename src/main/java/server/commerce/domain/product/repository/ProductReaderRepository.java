package server.commerce.domain.product.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;

import server.commerce.domain.order.entity.Order;
import server.commerce.domain.product.entity.Product;

public interface ProductReaderRepository {

	Product findById(Long productId);

	List<Product> readAll();

	List<Product> readAllByIds(List<Long> productIds);

	List<Product> findTopSellingProducts(
		Order.OrderStatus status,
		LocalDateTime startDate,
		LocalDateTime endDate,
		Pageable pageable);
}
