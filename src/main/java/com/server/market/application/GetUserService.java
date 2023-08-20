package com.server.market.application;

import com.server.market.models.user.User;
import com.server.market.models.user.UserId;
import com.server.market.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetUserService {
    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(UserId userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
