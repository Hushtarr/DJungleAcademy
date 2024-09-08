package com.djungleacademy.entity;

import com.djungleacademy.entity.BaseEntity;
import com.djungleacademy.enums.MessageType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Contact")
public class Contact extends BaseEntity {


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobileNum;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private MessageType messageType;
}
