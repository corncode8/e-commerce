package server.commerce.api.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	private Receiver receiver;
	private List<ProductRequest> productRequestList;
	private Long paymentAmount;

}
