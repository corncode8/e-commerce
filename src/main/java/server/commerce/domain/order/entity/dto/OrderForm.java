package server.commerce.domain.order.entity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.commerce.api.dto.request.OrderRequest;

@Data
@AllArgsConstructor
public class OrderForm {
	private Long payAmount;
	private List<OrderProduct> orderProducts;
	private String receiverName;
	private String address;
	private String phone;

	public static OrderForm of(OrderRequest request, List<OrderProduct> orderProducts) {
		return new OrderForm(
			request.getPaymentAmount(),
			orderProducts,
			request.getReceiver().getName(),
			request.getReceiver().getAddress(),
			request.getReceiver().getPhone());
	}
}
