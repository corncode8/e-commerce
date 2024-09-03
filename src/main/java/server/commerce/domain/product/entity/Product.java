package server.commerce.domain.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import server.commerce.domain.common.BaseEntity;

@Entity
@Getter
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, updatable = false)
	private Long id;

	private String name;
	private Long price;
	private String description;
	private Long stockQuantity;

	public Long getTotalPrice(Long quantity) {
		return price * quantity;
	}

}
