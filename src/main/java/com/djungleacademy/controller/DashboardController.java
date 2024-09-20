package com.djungleacademy.controller;

import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DashboardController {
    private final UserService userService;

    @GetMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
//        throw new RuntimeException("there has some technical error");


//        if(authentication instanceof UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken){
//            System.out.println(usernamePasswordAuthenticationToken);
//        } else if (authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken) {
//            System.out.println(oAuth2AuthenticationToken);
//        }
        return "dashboard";
    }

}