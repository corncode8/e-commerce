package server.commerce.domain.user.entity;

import static server.commerce.api.support.response.BaseResponseStatus.NOT_ENOUGH_POINT;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "name")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "point")
	private Long point;

	@Column(name = "cart_id")
	private Long cartId;

	@Version
	private Long version;

	public User(Long id, Long point, String name, String address, String phone) {
		this.id = id;
		this.point = point;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public User(Long id, Long point) {
		this.id = id;
		this.point = point;
	}

	public void sumPoint(Long point) {
		this.point += point;
	}

	public void usePoint(Long point) {
		if (this.point - point < 0) {
			throw new BaseException(NOT_ENOUGH_POINT);
		}
		this.point -= point;
	}
}
