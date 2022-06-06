package com.api.safetech.publicationservice.comment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("tagMappingConfiguration")
public class MappingConfiguration {
   @Bean
    public CommentMapper commentMapper() {
        return new CommentMapper();
    }
}
