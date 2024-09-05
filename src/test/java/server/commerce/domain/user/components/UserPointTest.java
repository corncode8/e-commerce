package server.commerce.domain.user.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static server.commerce.api.support.response.BaseResponseStatus.NOT_ENOUGH_POINT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.user.entity.User;
import server.commerce.domain.user.repository.UserReaderRepository;

@ExtendWith(MockitoExtension.class)
public class UserPointTest {

	@Mock
	UserReaderRepository userReaderRepository;
	@InjectMocks
	UserPoint userPoint;

	@DisplayName("포인트 충전 테스트")
	@Test
	void pointChargeTest() {
		//given
		Long testId = 1L;
		User user = new User(testId, 500L);
		Long chargePoint = 50000L;

		when(userReaderRepository.findById(testId)).thenReturn(user);

		//when
		User result = userPoint.pointCharge(testId, chargePoint);

		//then
		assertNotNull(result);
		assertEquals(500 + 50000, user.getPoint());
	}

	@DisplayName("포인트 사용 테스트")
	@Test
	void pointUseTest() {
		//given
		Long testId = 1L;
		User user = new User(testId, 50000L);
		Long chargePoint = 10000L;

		when(userReaderRepository.findById(testId)).thenReturn(user);

		//when
		User result = userPoint.pointUse(testId, chargePoint);

		//then
		assertNotNull(result);
		assertEquals(50000 - 10000, user.getPoint());
	}

	@DisplayName("잔액부족 테스트")
	@Test
	void pointUseFailTest() {
		//given
		Long testId = 1L;
		User user = new User(testId, 5000L);
		Long chargePoint = 10000L;

		when(userReaderRepository.findById(testId)).thenReturn(user);

		//when & then
		BaseException exception = assertThrows(BaseException.class, () -> userPoint.pointUse(testId, chargePoint));
		assertEquals(NOT_ENOUGH_POINT.getMessage(), exception.getMessage());
	}

	@DisplayName("포인트 조회 테스트")
	@Test
	void getPointTest() {
		//given
		Long testId = 1L;
		User user = new User(testId, 50000L);

		when(userReaderRepository.findById(testId)).thenReturn(user);

		//when
		Long result = userPoint.getPoint(testId);

		//then
		assertNotNull(result);
		assertEquals(50000, user.getPoint());
	}
}
