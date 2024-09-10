package server.commerce.api.dto.response;

import lombok.Data;

@Data
public class ChargeResponse {
	private Long balance;

	public ChargeResponse(Long balance) {
		this.balance = balance;
	}
}
