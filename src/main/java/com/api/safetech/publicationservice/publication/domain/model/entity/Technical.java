package com.api.safetech.publicationservice.publication.domain.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Technical {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String birthday;
    private String aboutMe;
}
