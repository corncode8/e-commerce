package server.commerce.domain.product.infrastructure;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import server.commerce.domain.order.entity.Order;
import server.commerce.domain.product.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p "
		+ "JOIN OrderItem oi on p.id = oi.productId "
		+ "JOIN Order o on oi.orderId = o.id "
		+ "WHERE o.status = :orderStatus "
		+ "AND o.createdAt between : startDate and :endDate "
		+ "GROUP BY p.id "
		+ "ORDER BY SUM(oi.quantity) DESC")
	Page<Product> findTopSellingProducts(
		@Param("orderStatus") Order.OrderStatus orderStatus,
		@Param("startDate") LocalDateTime startDate,
		@Param("endDate") LocalDateTime endDate,
		Pageable pageable);

	List<Product> findByIdIn(List<Long> productIds);
}
