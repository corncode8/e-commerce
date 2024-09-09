package server.commerce.domain.order.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import server.commerce.api.dto.request.OrderRequest;
import server.commerce.api.dto.request.ProductRequest;
import server.commerce.api.dto.request.Receiver;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.order.entity.dto.OrderProduct;
import server.commerce.domain.order.repository.OrderRepository;
import server.commerce.domain.product.components.ProductReader;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.storage.Fixtures;
import server.commerce.domain.user.entity.User;

@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {

	@Mock
	private OrderRepository orderRepository;
	@Mock
	private OrderProductReader orderProductReader;

	@InjectMocks
	private OrderManager orderManager;

	@DisplayName("주문 생성")
	@Test
	void orderTest() {
	    //given
		User user = Fixtures.user(1L);
		Product product1 = Fixtures.product("후드티");
		Product product2 = Fixtures.product("맨투맨");

		List<OrderProduct> orderProducts = List.of(
			new OrderProduct(product1.getId(), product1.getName(), product1.getPrice(), product1.orderTotalPrice(5L), 5L),
			new OrderProduct(product2.getId(), product2.getName(), product2.getPrice(), product2.orderTotalPrice(3L), 3L));

		OrderRequest orderRequest = new OrderRequest(
			new Receiver(
				user.getName(),
				user.getAddress(),
				user.getPhone()
			),
			List.of(
				new ProductRequest(product1.getId(), 5L),
				new ProductRequest(product2.getId(), 3L)
			),
			50_000L
		);

		Order order = new Order(
			user.getId(),
			orderRequest.getPaymentAmount(),
			orderRequest.getReceiver().getAddress(),
			orderRequest.getReceiver().getName(),
			orderRequest.getReceiver().getPhone(),
			Order.OrderStatus.READY);

		when(orderProductReader.read(anyList())).thenReturn(orderProducts);
		when(orderRepository.create(any(), any())).thenReturn(order);

		//when
		Order result = orderManager.order(user.getId(), orderRequest);

		//then
		assertNotNull(result);
		assertEquals(result.getStatus(), Order.OrderStatus.READY);
		assertEquals(result.getPayAmount(), 50_000);
	}
}
