package server.commerce.api.dto.request;

import lombok.Data;

@Data
public class Receiver {
	private String name;
	private String address;
	private String phone;
}
