package com.pablozoani.webapp.layers.business.controller;

import com.pablozoani.webapp.layers.business.datatransferobject.InstructorDTO;
import com.pablozoani.webapp.layers.business.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class InstructorController {

    private static final String INSTRUCTOR_URL = "instructor/instructor";

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) { this.instructorService = instructorService; }

    @GetMapping("/instructor")
    public String getInstructor(Model model) {

        log.debug("getInstructor()");

        model.addAttribute("instructor", new InstructorDTO());

        model.addAttribute("instructors", instructorService.findAll());

        return INSTRUCTOR_URL;
    }

    @GetMapping("/instructor/{id}/update")
    public String updateInstructor(@PathVariable String id, Model model) {

        log.debug("updateInstructor()");

        InstructorDTO instructorDTO = instructorService.findDtoById(Long.valueOf(id));

        model.addAttribute("instructor", instructorDTO);

        model.addAttribute("instructors", instructorService.findAll());

        return INSTRUCTOR_URL;
    }

    @GetMapping("/instructor/{id}/delete")
    public String deleteInstructor(@PathVariable String id) {

        log.debug("deleteInstructor()");

        instructorService.deleteInstructorById(Long.valueOf(id));

        return "redirect:/instructor";
    }

    @PostMapping("/instructor/save")
    public String saveInstructor(@Valid @ModelAttribute InstructorDTO instructorDTO) {

        log.debug("saveInstructor()");

        instructorService.saveInstructor(instructorDTO);

        return "redirect:/instructor";
    }
}
