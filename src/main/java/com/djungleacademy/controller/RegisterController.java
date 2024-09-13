package com.djungleacademy.controller;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.entity.User;
import com.djungleacademy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/createUser")
    public String displayRegisterPage(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/createUser")
    public String creatUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Contact form validation failed due to : {}", bindingResult.getAllErrors());
            return "contact";
        }
        userService.save(userDTO);
        return "redirect:/login";
    }
}
