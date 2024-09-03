package server.commerce.domain.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, updatable = false)
	private Long id;

	private Long payAmount;
	private Long address;
	private Long receiverName;
	private String phone;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false, length = 10)
	private OrderStatus status = OrderStatus.ORDERED;


	private Long userId;
	private Long orderItemId;

	public enum OrderStatus {
		ORDERED, SHIPPED, DELIVERED
	}

}
