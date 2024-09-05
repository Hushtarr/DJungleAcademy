package com.djungleacademy.service.impl;

import com.djungleacademy.dto.ContactDTO;
import com.djungleacademy.entity.Contact;
import com.djungleacademy.enums.MessageType;
import com.djungleacademy.mapper.GlobalMapper;
import com.djungleacademy.repository.ContactRepository;
import com.djungleacademy.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    private final GlobalMapper mapper;
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository, GlobalMapper mapper) {
        this.contactRepository = contactRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(ContactDTO contactDTO) {
        Contact contact =mapper.convert(contactDTO, Contact.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = (authentication == null) ? "anonymous user" : authentication.getName();
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(name);
        contact.setMessageType(MessageType.UNREAD);
        contactRepository.save(contact);
        System.out.println("info saved");
    }

    @Override
    public void update(ContactDTO contactDTO) {
        Contact contact=contactRepository.findByEmail(contactDTO.getEmail());
        contact.setSubject(contactDTO.getSubject());
        contact.setMessage(contactDTO.getMessage());
        contact.setUpdatedAt(LocalDateTime.now());
        contactRepository.save(contact);
    }


    @Override
    public void delete(ContactDTO contactDTO) {

    }

    @Override
    public ContactDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ContactDTO> getAll() {
        return contactRepository.findAll().stream()
                .map(dto->mapper.convert(dto,ContactDTO.class))
                .collect(Collectors.toList());
    }
}
