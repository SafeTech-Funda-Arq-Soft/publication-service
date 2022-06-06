package com.api.safetech.publicationservice.comment.resource;

import com.api.safetech.publicationservice.comment.domain.model.entity.User;
import com.api.safetech.publicationservice.publication.resource.PublicationResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResource {
    private Long id;
    private String comment;
    private Integer userId;
    private User user;
    private PublicationResource publication;
}
