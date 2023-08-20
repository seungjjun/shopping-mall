package com.server.market.dtos.user;

import com.server.market.models.user.User;

public record UserDto(String id, String name) {
    public static UserDto of(User user) {
        return new UserDto(
            user.id().toString(),
            user.name()
        );
    }
}
