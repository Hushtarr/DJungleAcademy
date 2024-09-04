package com.djungleacademy.service;

import com.djungleacademy.dto.ContactDTO;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

public interface ContactService {
    void save(ContactDTO contactDTO);
    void update(ContactDTO contactDTO);
    void delete(ContactDTO contactDTO);
    ContactDTO getById(Long id);
    List<ContactDTO> getAll();
}
