package com.api.safetech.publicationservice.publication.service;

import com.api.safetech.publicationservice.publication.client.TechnicalClient;
import com.api.safetech.publicationservice.publication.domain.model.entity.Publication;
import com.api.safetech.publicationservice.publication.domain.model.entity.Technical;
import com.api.safetech.publicationservice.publication.domain.persistence.PublicationRepository;
import com.api.safetech.publicationservice.publication.domain.service.PublicationService;
import com.api.safetech.publicationservice.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final static String ENTITY = "Publication";

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    TechnicalClient technicalClient;


    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getById(Long publicationId) {

        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
        if (null != publication) {
            Technical technical = technicalClient.getById(publication.getTechnicalId()).getBody();
            publication.setTechnical(technical);
        }
        return publication;
        //return publicationRepository.findById(publicationId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public Publication create(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public Publication update(Long publicationId, Publication request) {
        return publicationRepository.findById(publicationId).map(publication ->
                        publicationRepository.save(publication
                                .withTitle(request.getTitle())
                                .withDescription(request.getDescription())
                                .withUrlImage(request.getUrlImage())
                                .withTechnicalId(request.getTechnicalId())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public ResponseEntity<?> delete(Long publicationId) {
        return publicationRepository.findById(publicationId).map(publication -> {
            publicationRepository.delete(publication);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, publicationId));
    }

    @Override
    public List<Publication> getByTechnicalId(Integer technicalId) {
        return publicationRepository.findByTechnicalId(technicalId);
    }
}