package server.commerce.domain.product.components;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.repository.ProductReaderRepository;
import server.commerce.domain.storage.Fixtures;

@ExtendWith(MockitoExtension.class)
public class ProductReaderTest {

	@Mock
	ProductReaderRepository productReaderRepository;
	@InjectMocks
	ProductReader productReader;
	@Test
	@DisplayName("상품 상세 조회")
	void readProduct() {
		// Given
		Long productId = 2L;

		Product product = Fixtures.product("맨투맨");
		when(productReaderRepository.findById(productId)).thenReturn(product);

		// When
		Product foundProduct = productReader.findById(productId);

		// Then
		assertNotNull(foundProduct);
		assertEquals(product.getId(), foundProduct.getId());
	}

	@Test
	@DisplayName("상품 목록을 불러온다.")
	void readAll() {
		// Given
		Product product1 = Fixtures.product("후드티");
		Product product2 = Fixtures.product("맨투맨");

		when(productReaderRepository.readAll()).thenReturn(List.of(product1, product2));

		// When
		List<Product> products = productReader.readAll();

		// Then
		assertEquals(products.size(), 2);
		assertEquals(products.get(0).getName(), product1.getName());
		assertEquals(products.get(1).getName(), product2.getName());
	}
}
