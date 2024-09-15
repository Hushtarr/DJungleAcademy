package com.djungleacademy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: delete role dto and entity if doesn't needed
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO{
    private Long id;
    private String description;
}
