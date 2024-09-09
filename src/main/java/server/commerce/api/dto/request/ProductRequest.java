package server.commerce.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {
	private Long id;
	private Long quantity;
}
