package com.pablozoani.webapp.init;

import com.pablozoani.webapp.layers.business.repository.*;
import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import com.pablozoani.webapp.layers.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import static com.pablozoani.webapp.layers.model.base.FieldOfStudy.COMPUTER_SCIENCE;
import static com.pablozoani.webapp.layers.model.base.FieldOfStudy.MATHEMATICS;

@Slf4j
@Component
public class StartUp implements ApplicationListener<ContextRefreshedEvent> {

    private final AcademyDAO academyDAO;

    private final CourseDAO courseDAO;

    private final StudentDAO studentDAO;

    private final InstructorDAO instructorDAO;

    @Autowired
    public StartUp(AcademyDAO academyDAO, CourseDAO courseDAO,
                   StudentDAO studentDAO, InstructorDAO instructorDAO) {

        this.academyDAO = academyDAO;

        this.courseDAO = courseDAO;

        this.studentDAO = studentDAO;

        this.instructorDAO = instructorDAO;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //load();
    }

    private void load() {

        Academy academy = new Academy("Software Engineering Academy");

        Instructor instructorParker = new Instructor("Peter", "Parker", "spiderman@example.com");

        Student studentWayne = new Student("Bruce", "Wayne", "batman@email.net");

        Student studentCroft = new Student("Lara", "Croft", "croft_lara@foo.com");

        Student studentLane = new Student("Lois", "Lane", "lane@earth.universe");

        Student studentKrueger = new Student("Freddy", "Krueger", "sleep@good.com");

        Course oop = new Course("Object Oriented Programming", COMPUTER_SCIENCE, instructorParker, academy);

        oop.addStudent(studentWayne);

        oop.addStudent(studentCroft);

        courseDAO.save(oop);

        academy = academyDAO.findById(1L).orElseThrow(RuntimeException::new);

        Instructor instructorJane = new Instructor("Mary", "Jane", "jane@mary.bar");

        Course calculus = new Course("Calculus", MATHEMATICS, instructorJane, academy);

        calculus.addStudent(studentLane);

        calculus.addStudent(studentKrueger);

        courseDAO.save(calculus);
    }
}
