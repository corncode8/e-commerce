package server.commerce.domain.user.components;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import server.commerce.domain.user.entity.User;
import server.commerce.domain.user.repository.UserReaderRepository;

@Component
@RequiredArgsConstructor
public class UserPoint {

	private final UserReaderRepository userReaderRepository;

	public User getPoint(Long id) {
		User user = userReaderRepository.findById(id);

		return user;
	}

	public User pointCharge(Long id, Long point) {
		User user = userReaderRepository.findById(id);
		user.sumPoint(point);

		return user;
	}

	public User pointUse(Long id, Long point) {
		User user = userReaderRepository.findById(id);
		user.usePoint(point);

		return user;
	}
}
