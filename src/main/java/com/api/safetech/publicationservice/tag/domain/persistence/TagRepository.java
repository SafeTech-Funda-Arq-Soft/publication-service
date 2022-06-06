package com.api.safetech.publicationservice.tag.domain.persistence;

import com.api.safetech.publicationservice.tag.domain.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByPublicationId(Long publicationId);
}