package com.djungleacademy.controller;

import com.djungleacademy.dto.LessonDTO;
import com.djungleacademy.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;


}
