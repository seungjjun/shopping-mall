package com.server.market.application;

import com.server.market.security.AccessTokenGenerator;
import com.server.market.security.AuthUserDao;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    private final AuthUserDao authUserDao;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenGenerator accessTokenGenerator;

    public LoginService(AuthUserDao authUserDao, PasswordEncoder passwordEncoder, AccessTokenGenerator accessTokenGenerator) {
        this.authUserDao = authUserDao;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenGenerator = accessTokenGenerator;
    }

    public String login(String email, String password) {
        return authUserDao.findByEmail(email)
            .filter(authUser -> passwordEncoder.matches(password, authUser.password()))
            .map(authUser -> {
                String id = authUser.id();
                String accessToken = accessTokenGenerator.generate(id);
                authUserDao.addAccessToken(id, accessToken);
                return accessToken;
            }).orElseThrow(() -> new BadCredentialsException("Login failed"));
    }
}
