package server.commerce.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Receiver {
	private String name;
	private String address;
	private String phone;
}
