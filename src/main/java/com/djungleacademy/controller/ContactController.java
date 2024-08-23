package com.djungleacademy.controller;

import com.djungleacademy.dto.ContactFormDTO;
import com.djungleacademy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact";
    }

    @PostMapping("/saveMsg")
    public String saveMessage(ContactFormDTO contactFormDTO){
        contactService.save(contactFormDTO);
        return "redirect:/contact";
    }
}
