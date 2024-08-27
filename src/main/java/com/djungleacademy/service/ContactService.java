package com.djungleacademy.service;

import com.djungleacademy.dto.ContactFormDTO;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public interface ContactService {
    void save(ContactFormDTO contactFormDTO);
    void update(ContactFormDTO contactFormDTO);
    void delete(ContactFormDTO contactFormDTO);
    ContactFormDTO getById(Long id);
}
