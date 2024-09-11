package server.commerce.api.dto.request;

import lombok.Data;

@Data
public class ChargeRequest {

	private Long userId;
	private Long amount;
}
