package com.djungleacademy.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class Address extends BaseEntity {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Long zipCode;
}
