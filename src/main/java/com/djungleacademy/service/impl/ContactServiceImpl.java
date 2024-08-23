package com.djungleacademy.service.impl;

import com.djungleacademy.dto.ContactFormDTO;
import com.djungleacademy.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Override
    public void save(ContactFormDTO contactFormDTO) {
        contactFormDTO.setIsSaved(true);
    }

    @Override
    public void update(ContactFormDTO contactFormDTO) {

    }

    @Override
    public void delete(ContactFormDTO contactFormDTO) {

    }

    @Override
    public ContactFormDTO getById(Long id) {
        return null;
    }
}
