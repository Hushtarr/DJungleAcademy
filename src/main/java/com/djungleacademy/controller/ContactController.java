package com.djungleacademy.controller;


import com.djungleacademy.dto.ContactDTO;
import com.djungleacademy.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
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
            log.error("Contact form validation failed due to : " + bindingResult.getAllErrors());
            return "contact";
        }
        contactService.save(contactDTO);
        return "redirect:/contact";
    }

    @GetMapping("/displayMessages")
    public String displayMessages(Model model) {
        List<ContactDTO> msg = contactService.getAll();
        model.addAttribute("contactMsgs", msg);
        return "messages";
    }

//
//    @RequestMapping(value = "/closeMsg",method = GET)
//    public String closeMsg(@RequestParam int id, Authentication authentication) {
//        contactService.updateMsgStatus(id,authentication.getName());
//        return "redirect:/displayMessages";
//    }



}