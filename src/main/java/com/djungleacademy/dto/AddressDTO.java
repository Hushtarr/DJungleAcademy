package com.djungleacademy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Long zipCode;
}
