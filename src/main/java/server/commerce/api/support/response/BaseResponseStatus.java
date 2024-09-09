package server.commerce.api.support.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

	/**
	 * 200 : 요청 성공
	 */
	SUCCESS(true, HttpStatus.OK.value(), "요청에 성공하였습니다."),

	/**
	 * 400 : Request, Response 오류
	 */
	NOT_FOUND_USER(false, HttpStatus.BAD_REQUEST.value(), "찾을 수 없는 유저입니다."),
	NOT_ENOUGH_POINT(false, HttpStatus.BAD_REQUEST.value(), "포인트가 부족합니다."),

	NOT_FOUND_PAYMENT(false, HttpStatus.NOT_FOUND.value(), "찾을 수 없는 결제내역 입니다."),

	NOT_FOUND_PRODUCT(false, HttpStatus.NOT_FOUND.value(), "찾을 수 없는 상품 입니다."),
	INSUFFICIENT_QUANTITY(false, HttpStatus.NOT_FOUND.value(), "찾을 수 없는 상품 입니다."),

	NOT_FOUND_STOCK(false, HttpStatus.BAD_REQUEST.value(), "재고 정보를 찾지 못했습니다."),

	/**
	 * 500 :  Database, Server 오류
	 */
	DATABASE_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스 연결에 실패하였습니다."),
	DATABASE_EMPTY(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "저장된 데이터가 없습니다."),
	SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버와의 연결에 실패하였습니다."),

	UNEXPECTED_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "예상치 못한 에러가 발생했습니다.");

	private final boolean isSuccess;
	private final int code;
	private final String message;

	private BaseResponseStatus(boolean isSuccess, int code, String message) {
		this.isSuccess = isSuccess;
		this.code = code;
		this.message = message;
	}
}