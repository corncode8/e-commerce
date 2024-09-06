package server.commerce.domain.product.entity;

import static server.commerce.api.support.response.BaseResponseStatus.INSUFFICIENT_QUANTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.common.BaseEntity;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Long price;

	@Column(name = "description")
	private String description;

	@Column(name = "stock_quantity")
	private Long stockQuantity;

	public Product(Long id, String name, Long price, String description, Long stockQuantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockQuantity = stockQuantity;
	}

	public Long getTotalPrice(Long quantity) {
		return price * quantity;
	}

	public void updateStock(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public void decreaseStock(Long quantity) {
		this.stockQuantity = this.stockQuantity - quantity;
	}

	public Product toProduct() {
		return new Product(getId(), name, price, description, stockQuantity);
	}

	public void isEnoughStockQuantity(Long quantity) {
		if (this.stockQuantity < quantity) {
			throw new BaseException(INSUFFICIENT_QUANTITY);
		}
	}
}
