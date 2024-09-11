package server.commerce.api.dto.response;


import lombok.Data;
import server.commerce.domain.user.entity.User;

@Data
public class WalletResponse {

	private Long id;
	private Long balance;

	public WalletResponse(User user) {
		this.id = user.getId();
		this.balance = user.getPoint();
	}
}
