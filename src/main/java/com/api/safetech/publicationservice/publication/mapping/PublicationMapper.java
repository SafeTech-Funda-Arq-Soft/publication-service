package com.api.safetech.publicationservice.publication.mapping;

import com.api.safetech.publicationservice.publication.domain.model.entity.Publication;
import com.api.safetech.publicationservice.publication.resource.CreatePublicationResource;
import com.api.safetech.publicationservice.publication.resource.PublicationResource;
import com.api.safetech.publicationservice.publication.resource.UpdatePublicationResource;
import com.api.safetech.publicationservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublicationMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    // Object Mapping
    public PublicationResource toResource(Publication model)
    {
        return mapper.map(model, PublicationResource.class);
    }

    public List<PublicationResource> toResource(List<Publication> model)
    {
        return mapper.mapList(model, PublicationResource.class);
    }

    public Publication toModel(CreatePublicationResource resource)
    {
        return mapper.map(resource, Publication.class);
    }

    public Publication toModel(UpdatePublicationResource resource)
    {
        return mapper.map(resource, Publication.class);
    }

}