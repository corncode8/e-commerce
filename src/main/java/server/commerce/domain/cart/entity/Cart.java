package server.commerce.domain.cart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import server.commerce.domain.common.BaseEntity;

@Entity
@Getter
public class Cart extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id", nullable = false, updatable = false)
	private Long id;

	private Long userId;
	private Long cartItemId;

}
