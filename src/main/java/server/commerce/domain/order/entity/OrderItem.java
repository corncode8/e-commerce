package server.commerce.domain.order.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderitem_id", nullable = false, updatable = false)
	private Long id;

	private String productName;
	private Long price;
	private Long totalPrice;
	private Long quantity;

	private Long orderId;
	private Long productId;
}
