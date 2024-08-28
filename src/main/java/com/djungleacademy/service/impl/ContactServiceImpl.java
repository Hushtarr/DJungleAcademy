package com.djungleacademy.service.impl;

import com.djungleacademy.dto.ContactFormDTO;
import com.djungleacademy.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ContactServiceImpl implements ContactService {


    @Override
    public void save(ContactFormDTO contactFormDTO) {
        System.out.println("info saved");
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
