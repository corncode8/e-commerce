package server.commerce.api.dto.response;

import lombok.Data;

@Data
public class BalanceResponse {

	private Long balance;

	public BalanceResponse(Long balance) {
		this.balance = balance;
	}
}
