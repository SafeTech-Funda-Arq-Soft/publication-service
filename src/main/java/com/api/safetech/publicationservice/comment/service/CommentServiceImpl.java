package com.api.safetech.publicationservice.comment.service;

import com.api.safetech.publicationservice.comment.client.UserClient;
import com.api.safetech.publicationservice.comment.domain.model.entity.Comment;
import com.api.safetech.publicationservice.comment.domain.model.entity.User;
import com.api.safetech.publicationservice.comment.domain.persistence.CommentRepository;
import com.api.safetech.publicationservice.comment.domain.service.CommentService;
import com.api.safetech.publicationservice.publication.domain.model.entity.Publication;
import com.api.safetech.publicationservice.publication.domain.persistence.PublicationRepository;
import com.api.safetech.publicationservice.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final static String ENTITY = "Comment";

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    UserClient userClient;

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(Long commentId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
        if(null != comment) {
            User user = userClient.getUserById(comment.getUserId()).getBody();
            comment.setUser(user);
        }
        return comment;
    }

    @Override
    public Comment create(Comment comment, Long publicationId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication not found with Id" + publicationId));
        comment.setPublication(publication);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Long commentId, Comment request) {
        return commentRepository.findById(commentId).map(comment ->
                        commentRepository.save(comment
                                .withComment(request.getComment())
                                .withUserId(request.getUserId())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,commentId));
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return commentRepository.findById(commentId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
    @Override
    public List<Comment> getByPublicationId(Long publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }
    @Override
    public List<Comment> getByUserId(Integer userId) {
        return commentRepository.findByUserId(userId);
    }
}
