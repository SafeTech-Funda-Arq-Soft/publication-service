package com.api.safetech.publicationservice.publication.client;

import com.api.safetech.publicationservice.publication.domain.model.entity.Technical;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "technical-service", fallback = TechnicalHystrixFallbackFactory.class)
public interface TechnicalClient {

    @GetMapping("api/v1/technicals/{technicalId}")
    public ResponseEntity<Technical> getById(@PathVariable Long technicalId);
}
