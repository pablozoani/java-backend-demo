package com.pablozoani.webapp.layers.business.controller;

import com.pablozoani.webapp.layers.business.datatransferobject.StudentDTO;
import com.pablozoani.webapp.layers.business.service.CourseService;
import com.pablozoani.webapp.layers.business.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
public class StudentController {

    public static final String STUDENT_URL = "student/student";

    public static final String STUDENT_COURSES_URL = "student/courses";

    private final StudentService studentService;
    
    private final CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        
        this.studentService = studentService;
        
        this.courseService = courseService;
    }

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

    @GetMapping("/student/{id}/courses")
    public String showCourses(@PathVariable String id, Model model) {

        log.debug("showCourses()");

        model.addAttribute("student", studentService.findDtoById(Long.valueOf(id)));

        model.addAttribute("courses", courseService.findAll());

        model.addAttribute("studentCourses", studentService.getCoursesById(Long.valueOf(id)));

        return STUDENT_COURSES_URL;
    }

    @PostMapping("/student/{studentId}/courses/add")
    public String addCourseToStudent(@RequestParam("course_id") String courseId,
                                     @PathVariable String studentId) {

        log.debug("addCourseToStudent()");

        log.debug("courseId -> {}, studentId -> {}", courseId, studentId);

        courseService.addStudent(Long.valueOf(courseId), Long.valueOf(studentId));

        return "redirect:/student/" + studentId + "/courses";
    }

    @GetMapping("/student/{studentId}/courses/{courseId}/delete")
    public String removeCourseFromStudent(@PathVariable String studentId,
                                          @PathVariable String courseId) {

        log.debug("removeCourseFromStudent()");

        courseService.removeStudentById(Long.valueOf(courseId), Long.valueOf(studentId));
        
        return "redirect:/student/" + studentId + "/courses";
    }
}
