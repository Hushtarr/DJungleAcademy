package com.djungleacademy.repository;

import com.djungleacademy.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByEmail(String email);
    List<Contact> findAllByIsDeleted(Boolean isDeleted);
}
