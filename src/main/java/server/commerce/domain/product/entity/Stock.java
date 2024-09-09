package server.commerce.domain.product.entity;

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
@Table(name = "product_stock")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "stock_quantity")
	private Long stockQuantity;

	public Stock(Long id, Long productId, Long stockQuantity) {
		this.id = id;
		this.productId = productId;
		this.stockQuantity = stockQuantity;
	}

	public Stock toStock() {
		return new Stock(id, productId, stockQuantity);
	}

	public void updateStock(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
