package server.commerce.domain.user.repository;

import server.commerce.domain.user.entity.User;

public interface UserReaderRepository {

	User findById(Long id);
}
