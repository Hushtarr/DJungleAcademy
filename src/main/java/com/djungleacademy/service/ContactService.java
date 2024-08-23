package com.djungleacademy.service;

import com.djungleacademy.dto.ContactFormDTO;

public interface ContactService {
    void save(ContactFormDTO contactFormDTO);
    void update(ContactFormDTO contactFormDTO);
    void delete(ContactFormDTO contactFormDTO);
    ContactFormDTO getById(Long id);
}
