package server.commerce.domain.product.components;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.entity.Stock;
import server.commerce.domain.product.repository.StockRepository;
import server.commerce.domain.storage.Fixtures;

@ExtendWith(MockitoExtension.class)
public class StockReaderTest {

	@Mock
	private StockRepository stockRepository;

	@InjectMocks
	private StockReader stockReader;

	@Test
	@DisplayName("상품 재고를 가져온다.")
	void getProductStock() {
		// Given
		Product product = Fixtures.product("후드티");
		Long stockQuantity = 5L;

		Stock stock = new Stock(1L, product.getId(), stockQuantity);

		when(stockRepository.findByProductId(any())).thenReturn(stock);

		// When
		Stock foundStock = stockReader.readByProductId(product.getId());

		// Then
		assertThat(foundStock.getProductId()).isEqualTo(1L);
		assertThat(foundStock.getStockQuantity()).isEqualTo(5L);
	}
}
