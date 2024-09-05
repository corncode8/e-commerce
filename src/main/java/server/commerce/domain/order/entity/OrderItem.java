package server.commerce.domain.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderitem_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private Long price;

	@Column(name = "total_price")
	private Long totalPrice;

	@Column(name = "quantity")
	private Long quantity;


	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "product_id")
	private Long productId;

	public OrderItem(Long id, String productName, Long price, Long totalPrice, Long quantity, Long orderId,
		Long productId) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.orderId = orderId;
		this.productId = productId;
	}
}
