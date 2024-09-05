package server.commerce.domain.user.infrastructure;

import static server.commerce.api.support.response.BaseResponseStatus.NOT_FOUND_USER;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import server.commerce.api.support.exceptions.BaseException;
import server.commerce.domain.user.entity.User;
import server.commerce.domain.user.repository.UserReaderRepository;

@Repository
@RequiredArgsConstructor
public class UserCoreReaderRepository implements UserReaderRepository {
	private final UserJpaRepository userJpaRepository;

	@Override
	public User findById(Long id) {
		return userJpaRepository.findById(id)
			.orElseThrow(() -> new BaseException(NOT_FOUND_USER));
	}

}
