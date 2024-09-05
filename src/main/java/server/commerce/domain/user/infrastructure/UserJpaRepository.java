package server.commerce.domain.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import server.commerce.domain.user.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
