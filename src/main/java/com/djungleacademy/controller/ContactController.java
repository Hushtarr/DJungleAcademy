package com.djungleacademy.controller;

import com.djungleacademy.dto.ContactFormDTO;
import com.djungleacademy.service.ContactService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage( Model model) {
        model.addAttribute("contactFormDTO",  new ContactFormDTO());
        return "contact";
    }

    @RequestMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute ContactFormDTO contactFormDTO, Errors errors,Model model){
        if(errors.hasErrors()){
            System.out.println(errors);
            return "contact";
        }
        contactService.save(contactFormDTO);
        return "redirect:/contact";
    }
}
