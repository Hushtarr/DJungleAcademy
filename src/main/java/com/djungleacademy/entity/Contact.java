package com.djungleacademy.entity;

import com.djungleacademy.entity.BaseEntity;
import com.djungleacademy.enums.MessageType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Contact")
public class Contact extends BaseEntity {


    private String name;

    private String mobileNum;

    private String email;

    private String subject;

    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private MessageType messageType;
}
