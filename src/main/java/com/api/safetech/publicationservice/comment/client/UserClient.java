package com.api.safetech.publicationservice.comment.client;

import com.api.safetech.publicationservice.comment.domain.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", fallback = UserHystrixFallbackFactory.class)
public interface UserClient {
    @GetMapping("api/v1/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId);
}
