package server.commerce.domain.order.infrastructure;

import static server.commerce.api.support.response.BaseResponseStatus.NOT_FOUND_PRODUCT;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.order.entity.OrderItem;
import server.commerce.domain.order.repository.OrderItemReaderRepository;

@Repository
@RequiredArgsConstructor
public class OrderItemCoreReaderRepository implements OrderItemReaderRepository {

	private final OrderItemJpaRepository orderItemJpaRepository;

	@Override
	public OrderItem findById(Long orderItemId) {
		return orderItemJpaRepository.findById(orderItemId)
			.orElseThrow(() -> new BaseException(NOT_FOUND_PRODUCT));
	}

}
