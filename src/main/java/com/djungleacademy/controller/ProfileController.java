package com.djungleacademy.controller;

import com.djungleacademy.dto.UserDTO;
import com.djungleacademy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProfileController {
    private final UserService userService;

    @GetMapping("/updateProfile")
    public String showProfilePage(Model model, Authentication authentication) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = userService.findByEmail(auth.getName());
        model.addAttribute("user", userDTO);
        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Update failed due to : {}", bindingResult.getAllErrors());
            return "profile";
        }
        userService.update(userDTO);

        return "redirect:/dashboard";
    }

}
