package com.api.safetech.publicationservice.comment.client;

import com.api.safetech.publicationservice.comment.domain.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserHystrixFallbackFactory implements UserClient {

    @Override
    public ResponseEntity<User> getUserById(Long userId) {
        Date now = new Date();
        User user = User.builder()
                .firstName("none")
                .lastName("none")
                .dni("none")
                .email("none")
                .password("none")
                .address("none")
                .phone("none")
                .birthday(now)
                .build();
        return ResponseEntity.ok(user);
    }
}
