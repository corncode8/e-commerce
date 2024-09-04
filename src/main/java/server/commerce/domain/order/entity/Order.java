package server.commerce.domain.order.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "pay_amount")
	private Long payAmount;

	@Column(name = "address")
	private String address;

	@Column(name = "receiver_name")
	private String receiverName;

	@Column(name = "phone")
	private String phone;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "status", nullable = false, length = 10)
	private OrderStatus status = OrderStatus.ORDERED;

	@Column(name = "user_id")
	private Long userId;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "orderitem_id")
	private List<Long> orderItemId = new ArrayList<>();

	public enum OrderStatus {
		READY, ORDERED, CANCELED , SHIPPED, DELIVERED
	}

	public Order(Long id, Long payAmount, String address, String receiverName, String phone, OrderStatus status,
		Long userId,
		List<Long> orderItemId) {
		this.id = id;
		this.payAmount = payAmount;
		this.address = address;
		this.receiverName = receiverName;
		this.phone = phone;
		this.status = status;
		this.userId = userId;
		this.orderItemId = orderItemId;
	}
}
