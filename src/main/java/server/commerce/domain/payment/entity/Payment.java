package server.commerce.domain.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import server.commerce.domain.common.BaseEntity;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "orderId")
	private Long orderId;

	@Column(name = "pay_amount")
	private Long payAmount;

	public Payment(Long orderId, Long payAmount) {
		this.orderId = orderId;
		this.payAmount = payAmount;
	}
}
