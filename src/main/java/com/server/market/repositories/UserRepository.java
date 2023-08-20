package com.server.market.repositories;

import com.server.market.models.user.User;
import com.server.market.models.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findById(UserId userId);

    boolean existsByEmail(String email);
}
