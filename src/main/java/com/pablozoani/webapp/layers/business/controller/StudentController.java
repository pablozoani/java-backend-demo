package com.pablozoani.webapp.layers.business.controller;

import com.pablozoani.webapp.layers.business.datatransferobject.StudentDTO;
import com.pablozoani.webapp.layers.business.service.StudentService;
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
public class StudentController {

    public static final String STUDENT_URL = "/student/student";

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) { this.studentService = studentService; }

    @GetMapping("/student")
    public String getStudent(Model model) {

        log.debug("getStudent()");

        model.addAttribute("student", new StudentDTO());

        model.addAttribute("students", studentService.findAll());

        return STUDENT_URL;
    }

    @GetMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable String id) {

        log.debug("deleteStudent()");

        studentService.deleteById(Long.valueOf(id));

        return "redirect:/student";
    }

    @GetMapping("/student/{id}/update")
    public String updateStudent(@PathVariable String id, Model model) {

        log.debug("updateStudent()");

        StudentDTO studentDTO = studentService.findDtoById(Long.valueOf(id));

        model.addAttribute("student", studentDTO);

        model.addAttribute("students", studentService.findAll());

        return STUDENT_URL;
    }

    @PostMapping("/student/save")
    public String saveStudent(@Valid @ModelAttribute StudentDTO studentDTO) {

        log.debug("saveStudent()");

        studentService.saveStudent(studentDTO);

        return "redirect:/student";
    }
}
