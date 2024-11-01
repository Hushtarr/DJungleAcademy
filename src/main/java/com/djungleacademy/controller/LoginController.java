//package com.djungleacademy.controller;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class LoginController {
//
//    @GetMapping("/login")
//    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
//                                   @RequestParam(value = "logout", required = false) String logout,
//                                   @RequestParam(value = "register", required = false) String register,
//                                   Model model) {
//        String msg = null;
//        if (error != null) {
//            msg = "Username or Password is incorrect !!";
//        }
//        if (logout != null) {
//            msg = "You have been successfully logged out !!";
//        }
//        if (register!= null) {
//            msg = "You have successfully registered !!";
//        }
//        model.addAttribute("errorMessage", msg);
//        return "login"; // 返回登录页面视图
//    }
//
//    @PostMapping("/login")
//    public String processLogin() {
//        // 如果你有自定义的登录处理逻辑，放在这里
//        // 否则不需要，因为 Spring Security 会自动处理登录认证
//        return "redirect:/dashboard"; // 登录成功后重定向到 dashboard
//    }
//
//
//    @GetMapping("/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response,null);
//        return "redirect:/login?logout=true";
//    }
//}
//
