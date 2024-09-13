package server.commerce.domain.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import server.commerce.domain.common.BaseEntity;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "pay_amount")
	private Long payAmount;

	@Column(name = "address")
	private String address;

	@Column(name = "receiver_name", length = 100)
	private String receiverName;

	@Column(name = "phone", length = 100)
	private String phone;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "status", nullable = false, length = 10)
	private OrderStatus status = OrderStatus.READY;

	@Column(name = "user_id")
	private Long userId;


	public enum OrderStatus {
		READY, ORDERED, CANCELED , SHIPPED, DELIVERED, FAIL
	}

	public Order(Long id, Long payAmount, String address, String receiverName, String phone, OrderStatus status,
		Long userId) {
		this.id = id;
		this.payAmount = payAmount;
		this.address = address;
		this.receiverName = receiverName;
		this.phone = phone;
		this.status = status;
		this.userId = userId;
	}

	public Order(Long userId, Long payAmount, String address, String receiverName, String phone, OrderStatus status) {
		this.userId = userId;
		this.payAmount = payAmount;
		this.address = address;
		this.receiverName = receiverName;
		this.phone = phone;
		this.status = status;
	}

	public void orderFailed() {
		this.status = OrderStatus.FAIL;
	}
	public void setOrdered() {
		this.status = OrderStatus.ORDERED;
	}
}
