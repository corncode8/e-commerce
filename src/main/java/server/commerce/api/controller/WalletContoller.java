package server.commerce.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import server.commerce.api.dto.request.ChargeRequest;
import server.commerce.api.dto.response.ChargeResponse;
import server.commerce.api.dto.response.WalletResponse;
import server.commerce.api.support.response.BaseResponse;
import server.commerce.domain.user.components.UserPoint;
import server.commerce.domain.user.entity.User;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class WalletContoller {

	private final UserPoint userPoint;

	/*
	* 유저 잔액 조회
	*
	* @param userId 유저 아이디
	* @return 잔액 정보 return
	* */
	@GetMapping("/{id}")
	public BaseResponse<WalletResponse> getUserWallet(@PathVariable("id") Long id) {
		User user = userPoint.getPoint(id);
		return new BaseResponse<>(new WalletResponse(user));
	}

	@PatchMapping("/charge")
	public BaseResponse<ChargeResponse> charge(@RequestBody ChargeRequest request) {
		User user = userPoint.pointCharge(request.getUserId(), request.getAmount());
		return new BaseResponse<>(new ChargeResponse(user));
	}
}
