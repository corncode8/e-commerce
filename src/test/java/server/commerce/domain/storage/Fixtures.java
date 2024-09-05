package server.commerce.domain.storage;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.product.entity.Product;

public class Fixtures {
	public static Product product(String name) {
		if (name.equals("후드티")) {
			return new Product(1L, "후드티", 250_000L, "지제로 후드티", 10L);
		}
		if (name.equals("맨투맨")) {
			return new Product(2L, "맨투맨", 150_000L, "노랑 맨투맨", 5L);
		}
		if (name.equals("모자")) {
			return new Product(3L, "모자", 50_000L, "뉴진스 모자", 15L);
		}
		if (name.equals("백팩")) {
			return new Product(4L, "백팩", 100_000L, "가죽 백팩", 15L);
		}
		if (name.equals("셔츠")) {
			return new Product(5L, "셔츠", 80_000L, "블랙 셔츠", 20L);
		}
		throw new EntityNotFoundException("Product Not Found - name: " + name);
	}

	public static Order order(Order.OrderStatus status) {
		if (status.equals(Order.OrderStatus.ORDERED)) {
			return new Order(1L, 350_000L,
				"서울특별시 송파구",
				"홍길동",
				"01012345678",
				Order.OrderStatus.ORDERED,
				1L,
				List.of(1L, 2L));
		}
		throw new EntityNotFoundException("Order Not Found - order status: " + status);
	}

	public static OrderItem orderItem(Long orderId, Long productId) {
		if (orderId.equals(1L) && productId.equals(1L)) {
			return new OrderItem(1L, "후드티", 250_000L, 250_000L, 1L, orderId, productId);
		}

		if (orderId.equals(1L) && productId.equals(2L)) {
			return new OrderItem(2L, "맨투맨", 150_000L, 150_000L, 1L, orderId, productId);
		}

		throw new EntityNotFoundException("Order Item Not Found - order id: " + orderId + ", product id: " + productId);
	}
}
