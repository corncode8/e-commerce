package server.commerce.domain.product.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import server.commerce.domain.order.entity.Order;
import server.commerce.domain.product.components.ProductManager;
import server.commerce.domain.product.components.ProductReader;
import server.commerce.domain.product.entity.Product;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductReader productReader;
	private final ProductManager productManager;

	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return productReader.readAll();
	}

	@Transactional(readOnly = true)
	public Product getProductDetail(Long productId) {
		return productReader.findById(productId);
	}

	@Cacheable(value = "products", key = "'popular'", cacheManager = "cacheManager")
	@Transactional(readOnly = true)
	public List<Product> readTopSellingProducts() {
		return productReader.readTopSellingProducts();
	}

	public List<Product> readAllByIds(List<Long> productIds) {
		return productReader.readAllByIds(productIds);
	}

	@Transactional
	public void updateProductStock(Order order) {
		productManager.updateProductStock(order);
	}

}
