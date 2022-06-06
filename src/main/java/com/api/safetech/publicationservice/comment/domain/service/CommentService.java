package com.api.safetech.publicationservice.comment.domain.service;

import com.api.safetech.publicationservice.comment.domain.model.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    Comment getById(Long commentId);
    Comment create(Comment comment, Long publicationId);
    Comment update(Long commentId, Comment request);
    ResponseEntity<?> delete(Long commentId);
    List<Comment> getByPublicationId(Long publicationId);
    List<Comment> getByUserId(Integer userId);
}
