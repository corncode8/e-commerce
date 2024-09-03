package server.commerce.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import server.commerce.domain.common.BaseEntity;

@Entity
@Getter
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long id;

	private String name;
	private String address;
	private String phone;
	private Long point;


	private Long cartId;
}
