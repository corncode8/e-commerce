package server.commerce.domain.product.components;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
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

	@DisplayName("최근 3일동안 가장 많이 팔링 상품 조회")
	@Test
	void readTopSellingProductsTest() {
	    //given
		when(productReaderRepository.findTopSellingProducts(any(), any(), any(), any())).thenReturn(
			List.of(
				Fixtures.product("후드티"),
				Fixtures.product("모자"),
				Fixtures.product("맨투맨"),
				Fixtures.product("백팩"),
				Fixtures.product("셔츠"))
		);

	    //when
		List<Product> result = productReader.readTopSellingProducts();

		//then
		assertNotNull(result);
		assertEquals(result.size(), 5);
		assertEquals(result.get(0).getName(), "후드티");
		assertEquals(result.get(4).getName(), "셔츠");

	}

	@Test
	@DisplayName("상품 id list 기반으로 상품을 조회.")
	void readAllProductByIds() {
		// Given
		List<Product> products = List.of(
			Fixtures.product("후드티"),
			Fixtures.product("맨투맨")
		);

		List<Long> productIds = products.stream().map(Product::getId).toList();

		when(productReaderRepository.readAllByIds(any())).thenReturn(products);


		// When
		List<Product> result = productReader.readAllByIds(productIds);

		// Then
		assertThat(result).isNotNull();
		assertThat(result.get(0).getName()).isEqualTo("후드티");
		assertThat(result.get(1).getName()).isEqualTo("맨투맨");
	}
}
