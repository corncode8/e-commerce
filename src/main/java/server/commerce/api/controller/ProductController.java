package server.commerce.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import server.commerce.api.dto.response.ProductListResponse;
import server.commerce.api.support.response.BaseResponse;
import server.commerce.api.dto.response.ProductResponse;
import server.commerce.domain.product.entity.Product;
import server.commerce.domain.product.service.ProductService;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	/*
	* 특정 상품 조회
	*
	* @param id 상품 아이디
	* @return 상품 정보 response
	* */
	@GetMapping("/{id}")
	public BaseResponse<ProductResponse> getProductById(@PathVariable("id") Long id) {
		Product productDetail = productService.getProductDetail(id);
		return new BaseResponse<>(new ProductResponse(productDetail));
	}

	/*
	* 상위 상품 조회
	*
	* @return 상품 ListResponse
	* */

	@GetMapping("/popular")
	public BaseResponse<ProductListResponse> popularProducts() {
		List<Product> products = productService.readTopSellingProducts();
		return new BaseResponse<>(new ProductListResponse(products));
	}

}
