package com.djungleacademy.controllers;

import com.djungleacademy.dto.ContactDTO;
import com.djungleacademy.dto.CourseDTO;
import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.dto.common.ApiInfo;
import com.djungleacademy.entity.Lesson;
import com.djungleacademy.enums.UserType;
import com.djungleacademy.service.ContactService;
import com.djungleacademy.service.CourseService;
import com.djungleacademy.service.LessonService;
import com.djungleacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        value = "/api/admin",
        produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})


public class AdminControllers {
    private final ContactService contactService;
    private final LessonService lessonService;
    private final UserService userService;
    private final CourseService courseService;

    @GetMapping("/displayMessages")
    public ResponseEntity<ApiInfo<List<ContactDTO>>> displayMessages() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("this is the list of messages",contactService.getAll()));
    }


    @PostMapping("/closeMsg/{id}")
    public ResponseEntity<ApiInfo<Void>> closeMsg(@PathVariable Long id) {
        contactService.updateMsgStatus(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successVoid("message closed"));
    }



    @GetMapping("/displayLessons")
    public ResponseEntity<ApiInfo<List<LessonDTO>>> displayLessons() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("this is the list of lessons",lessonService.findAll()));
    }

    @PostMapping("/addNewLesson")
    public String addNewLesson(@ModelAttribute("Lesson") LessonDTO lessonDTO,Model model) {
        lessonService.save(lessonDTO);
        return "redirect:/private/displayLessons";
    }

    @GetMapping("/updateLesson/{id}")
    public String updateLesson(@PathVariable Long id,Model model) {
        model.addAttribute("Lesson",lessonService.findById(id));
        model.addAttribute("instructors",userService.findByRole(UserType.INSTRUCTOR));
        model.addAttribute("courses",courseService.findAll());
        return "lesson_update";
    }

//    todo:update function to be done:controller & service layer
    @PostMapping("/updateLesson/{id}")
    public String updateLesson(@PathVariable Long id, @ModelAttribute Lesson lesson) {
        LessonDTO lessonDTO = lessonService.findById(id);
        lessonService.save(lessonDTO);
        return "redirect:/private/displayLessons";
    }

    @PostMapping("/deleteLesson/{id}")
    public String deleteLesson(@PathVariable("id")Long id) {
        lessonService.delete(id);
        return "redirect:/private/displayLessons";
    }


    @GetMapping("/displayCourses")
    public String displayCourses(Model model) {
        model.addAttribute("CourseDTO",new CourseDTO());
        model.addAttribute("Courses",courseService.findAll());
        model.addAttribute("professors",userService.findByRole(UserType.PROFESSOR));
        System.out.println(courseService.findAll().size());
        System.out.println(lessonService.findAll().size());
        return "course";
    }

    @PostMapping("/addNewCourse")
    public String addNewCourse(@ModelAttribute("CourseDTO") CourseDTO courseDTO,Model model) {
        model.addAttribute("professors",userService.findByRole(UserType.PROFESSOR));
        courseService.save(courseDTO);
        return "redirect:/private/displayCourses";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable("id") Long id,Model model) {
        model.addAttribute("Course",courseService.findById(id));
        model.addAttribute("professors",userService.findByRole(UserType.PROFESSOR));
        model.addAttribute("courses",courseService.findAll());
        return "course_update";
    }

    //    todo:update function to be done:controller & service layer
    @PostMapping("/updateCourse/{id}")
    public String updateLesson(@ModelAttribute CourseDTO courseDTO) {
        courseService.save(courseDTO);
        return "redirect:/private/displayCourses";
    }

    @PostMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable("id")Long id) {
        courseService.deleteCourse(id);
        return "redirect:/private/displayCourses";
    }

}
