package com.pablozoani.webapp.layers.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CourseController {

    public static final String COURSE_URL = "/course/course";

    @GetMapping("/course")
    public String getCourse() {
        return COURSE_URL;
    }
}
