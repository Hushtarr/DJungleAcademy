package com.djungleacademy.controller;

import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.enums.UserType;
import com.djungleacademy.service.ContactService;
import com.djungleacademy.service.LessonService;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/private")
public class AdminController {
    private final ContactService contactService;
    private final LessonService lessonService;
    private final UserService userService;

    @GetMapping("/displayMessages")
    public String displayMessages(Model model) {
        model.addAttribute("contactMsgs", contactService.getAll());
        System.out.println(contactService.getAll().size());
        return "message";
    }


    @PostMapping("/closeMsg/{id}")
    public String closeMsg(@PathVariable Long id) {
        contactService.updateMsgStatus(id);
        return "redirect:/private/displayMessages";
    }



    @GetMapping("/displayLessons")
    public String displaylessons(Model model) {
        model.addAttribute("Lesson",new LessonDTO());
        model.addAttribute("Lessons", lessonService.findAll());
        model.addAttribute("instructors",userService.findByRole(UserType.INSTRUCTOR));
        return "lesson";
    }

    @PostMapping("/addNewLesson")
    public String addNewLesson(@ModelAttribute("Lesson") LessonDTO lessonDTO) {
        // 调用 service 层保存课程
        lessonService.save(lessonDTO);
        // 提交成功后，重定向到课程列表页面
        return "redirect:/private/displayLessons";
    }

    @GetMapping("/displayCourses")
    public String displayCourses() {
        return "courses";
    }


}
