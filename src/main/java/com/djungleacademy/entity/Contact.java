package com.djungleacademy.entity;

import com.djungleacademy.entity.BaseEntity;
import com.djungleacademy.enums.ContactType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contact")
public class Contact extends BaseEntity {


    private String name;

    private String mobileNum;

    private String email;

    private String subject;

    private String message;

    @Column(name = "is_saved")
    private Boolean isSaved = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;
}
