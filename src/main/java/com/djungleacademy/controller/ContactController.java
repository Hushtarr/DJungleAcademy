package com.djungleacademy.controller;


import com.djungleacademy.dto.ContactDTO;
import com.djungleacademy.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new ContactDTO());
        return "contact";
    }

    @PostMapping( "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") ContactDTO contactDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("Contact form validation failed due to : {}", bindingResult.getAllErrors());
            return "contact";
        }
        contactService.save(contactDTO);
        return "redirect:/contact";
    }





}