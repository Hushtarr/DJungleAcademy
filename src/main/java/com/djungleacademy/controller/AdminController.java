package com.djungleacademy.controller;

import com.djungleacademy.dto.CourseDTO;
import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.enums.UserType;
import com.djungleacademy.service.ContactService;
import com.djungleacademy.service.CourseService;
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
    private final CourseService courseService;

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
    public String displayLessons(Model model) {
        model.addAttribute("Lesson",new LessonDTO());
        model.addAttribute("Lessons", lessonService.findAll());
        model.addAttribute("instructors",userService.findByRole(UserType.INSTRUCTOR));
        model.addAttribute("courses",courseService.findAll());
        return "lesson";
    }

    @PostMapping("/addNewLesson")
    public String addNewLesson(@ModelAttribute("Lesson") LessonDTO lessonDTO,Model model) {
        lessonService.save(lessonDTO);
        return "redirect:/private/displayLessons";
    }


    @GetMapping("/displayCourses")
    public String displayCourses(Model model) {
        model.addAttribute("CourseDTO",new CourseDTO());
        model.addAttribute("Courses",courseService.findAll());
        model.addAttribute("professors",userService.findByRole(UserType.PROFESSOR));
        return "course";
    }

    @PostMapping("/addNewCourse")
    public String addNewCourse(@ModelAttribute("CourseDTO") CourseDTO courseDTO,Model model) {
        model.addAttribute("professors",userService.findByRole(UserType.PROFESSOR));
        courseService.save(courseDTO);
        return "redirect:/private/displayCourses";
    }


}
