package server.commerce.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import server.commerce.domain.user.components.UserPoint;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserPoint userPoint;

	@Transactional
	public Long charge(Long userId, Long amount) {
		return userPoint.pointCharge(userId, amount);
	}

	@Transactional(readOnly = true)
	public Long getBalance(Long userId) {
		return userPoint.getPoint(userId);
	}
}
