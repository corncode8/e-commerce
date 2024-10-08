package server.commerce.api.dto.response;

import lombok.Data;
import server.commerce.domain.user.entity.User;

@Data
public class ChargeResponse {
	private Long balance;

	public ChargeResponse(User user) {
		this.balance = user.getPoint();
	}
}
