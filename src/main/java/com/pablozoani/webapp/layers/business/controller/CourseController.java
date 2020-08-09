package com.pablozoani.webapp.layers.business.controller;

import com.pablozoani.webapp.layers.business.datatransferobject.AcademyDTO;
import com.pablozoani.webapp.layers.business.datatransferobject.CourseDTO;
import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.service.AcademyService;
import com.pablozoani.webapp.layers.business.service.CourseService;
import com.pablozoani.webapp.layers.business.service.InstructorService;
import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Slf4j
@Controller
public class CourseController {

    public static final String COURSE_URL = "/course/course";

    private final InstructorService instructorService;

    private final CourseService courseService;

    private final AcademyService academyService;

    @Autowired
    public CourseController(InstructorService instructorService,
                            CourseService courseService,
                            AcademyService academyService) {

        this.instructorService = instructorService;

        this.courseService = courseService;

        this.academyService = academyService;
    }

    @GetMapping("/course")
    public String getCourse(Model model) {

        log.debug("getCourse()");

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setInstructor(new InstructorDTO());

        courseDTO.setAcademy(new AcademyDTO());

        model.addAttribute("course", courseDTO);

        Set<Instructor> instructors = instructorService.findAll();

        model.addAttribute("instructors", instructors);

        Set<Academy> academies = academyService.findAll();

        model.addAttribute("academies", academies);

        Set<Course> courses = courseService.findAll();

        model.addAttribute("courses", courses);

        return COURSE_URL;
    }

    @GetMapping("/course/{id}/update")
    public String updateCourse(@PathVariable String id, Model model) {

        log.debug("updateCourse()");

        CourseDTO courseDTO = courseService.findDtoById(Long.valueOf(id));

        model.addAttribute("course", courseDTO);

        Set<Instructor> instructors = instructorService.findAll();

        model.addAttribute("instructors", instructors);

        Set<Academy> academies = academyService.findAll();

        model.addAttribute("academies", academies);

        Set<Course> courses = courseService.findAll();

        model.addAttribute("courses", courses);

        return COURSE_URL;
    }

    @GetMapping("/course/{id}/delete")
    public String deleteCourse(@PathVariable String id) {

        log.debug("deleteCourse()");

        courseService.deleteById(Long.valueOf(id));

        return "redirect:/course";
    }

    @PostMapping("/course/save")
    public String saveCourse(@ModelAttribute CourseDTO courseDTO) {

        log.debug("saveCourse() -> {}", courseDTO);

        courseService.saveCourse(courseDTO);

        return "redirect:/course";
    }
}