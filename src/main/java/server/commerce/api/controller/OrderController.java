package server.commerce.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import server.commerce.api.dto.request.OrderRequest;
import server.commerce.api.dto.response.OrderResponse;
import server.commerce.api.support.response.BaseResponse;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	/*
	* 상품 주문
	*
	* @param id 사용자 아이디, OrderRequest 주문 정보
	* @return 주문 정보 response
	* */
	@PostMapping("/{userId}")
	public BaseResponse<OrderResponse> order(@PathVariable("id") Long id, OrderRequest request) {
		Order order = orderService.order(id, request);
		return new BaseResponse<>(new OrderResponse(order));
	}
}
