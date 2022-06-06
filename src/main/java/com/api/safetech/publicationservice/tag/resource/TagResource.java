package com.api.safetech.publicationservice.tag.resource;

import com.api.safetech.publicationservice.publication.resource.PublicationResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResource {
    private Long id;
    private String tag;
    private PublicationResource publication;
}
