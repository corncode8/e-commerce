package server.commerce.api.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {
	private Receiver receiver;
	private List<ProductRequest> productRequestList;
	private Long paymentAmount;

}
