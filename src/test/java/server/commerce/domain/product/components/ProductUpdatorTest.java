package server.commerce.domain.product.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import server.commerce.domain.order.entity.Order;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.order.repository.OrderItemReaderRepository;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.repository.ProductReaderRepository;
import server.commerce.domain.storage.Fixtures;

@ExtendWith(MockitoExtension.class)
public class ProductUpdatorTest {

	@Mock
	ProductReaderRepository productReaderRepository;
	@Mock
	OrderItemReaderRepository orderItemReaderRepository;

	@InjectMocks
	ProductUpdator productUpdator;

	@DisplayName("updateStock 테스트")
	@Test
	void updateStockTest() {
	    //given
		Order order = Fixtures.order(Order.OrderStatus.ORDERED);

		Product product1 = Fixtures.product("후드티");
		Product product2 = Fixtures.product("맨투맨");

		List<Long> stockQuantity = List.of(product1.getStockQuantity(), product2.getStockQuantity());

		List<OrderItem> orderItems = List.of(
			Fixtures.orderItem(order.getId(), 1L),
			Fixtures.orderItem(order.getId(), 2L));

		when(orderItemReaderRepository.findById(order.getOrderItemId().get(0))).thenReturn(orderItems.get(0));
		when(orderItemReaderRepository.findById(order.getOrderItemId().get(1))).thenReturn(orderItems.get(1));

		when(productReaderRepository.findById(orderItems.get(0).getProductId())).thenReturn(product1);
		when(productReaderRepository.findById(orderItems.get(1).getProductId())).thenReturn(product2);

		//when
		productUpdator.updateStock(order);

	    //then
		assertEquals(stockQuantity.get(0) -1, product1.getStockQuantity());
	}

	public void updateStock(Order order) {
		List<OrderItem> orderItems = new ArrayList<>();

		for (Long item : order.getOrderItemId()) {
			orderItems.add(orderItemReaderRepository.findById(item));
		}

		for (OrderItem item : orderItems) {
			Product product = productReaderRepository.findById(item.getProductId());
			product.decreaseStock(item.getQuantity());
		}

	}
}
