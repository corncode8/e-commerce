package server.commerce.domain.order.entity.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderForm {
	private Long payAmount;
	private List<OrderProduct> orderProducts;
	private String receiverName;
	private String address;
	private String phone;
}
