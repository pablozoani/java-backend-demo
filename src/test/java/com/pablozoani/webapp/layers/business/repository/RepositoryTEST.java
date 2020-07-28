package com.pablozoani.webapp.layers.business.repository;

import com.pablozoani.webapp.layers.model.Academy;
import com.pablozoani.webapp.layers.model.Course;
import com.pablozoani.webapp.layers.model.Instructor;
import com.pablozoani.webapp.layers.model.Student;
import com.pablozoani.webapp.layers.model.base.FieldOfStudy;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
@SpringBootTest
class RepositoryTEST {

    @Autowired
    AcademyDAO academyDAO;

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    InstructorDAO instructorDAO;

    @Autowired
    StudentDAO studentDAO;

    @BeforeAll
    static void init() {

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        Academy academy1 = new Academy("Academy One");

        academy1 = academyDAO.save(academy1);

        assertNotNull(academy1.getId());
    }

    @Test
    void saveAll() {

        Academy academy2 = new Academy("Academy Two");

        Academy academy3 = new Academy("Academy Three");

        Set<Academy> academies = new HashSet<>();

        academyDAO.saveAll(Set.of(academy2, academy3))
                  .forEach(academies::add);

        assertEquals(2, academies.size());
    }

    @Test
    void findById() {

        Academy academy1 = new Academy("Academy One");

        academyDAO.save(academy1);

        Optional<Academy> academyOptional = academyDAO.findById(1L);

        assertTrue(academyOptional.isPresent() && academyOptional.get().equals(academy1));

        academyOptional = academyDAO.findById(1_000_000L);

        assertFalse(academyOptional.isPresent());
    }

    @Test
    void existsById() {

        Academy academy1 = new Academy("Academy One");

        academyDAO.save(academy1);

        assertTrue(academyDAO.existsById(1L));

        assertFalse(academyDAO.existsById(2L));
    }

    @Test
    void findAll() {

        Academy academy1 = new Academy("Academy One");

        Academy academy2 = new Academy("Academy Two");

        Academy academy3 = new Academy("Academy Three");

        Set<Academy> academies = new HashSet<>();

        academies.addAll(Set.of(academy1, academy2, academy3));

        academyDAO.saveAll(academies);

        academies.clear();

        academyDAO.findAll().forEach(academies::add);

        assertTrue(academies.size() == 3);
    }

    @Test
    void findAllById() {

        Academy academy1 = new Academy("Academy One");

        Academy academy2 = new Academy("Academy Two");

        Academy academy3 = new Academy("Academy Three");

        Set<Academy> academies = new HashSet<>();

        academies.addAll(Set.of(academy1, academy2, academy3));

        academyDAO.saveAll(academies);

        academies.clear();

        academyDAO.findAllById(Set.of(1L, 2L, 3L, 4L)).forEach(academies::add);

        assertTrue(academies.size() == 3);
    }

    @Test
    void count() {

        Academy academy1 = new Academy("Academy One");

        Academy academy2 = new Academy("Academy Two");

        Academy academy3 = new Academy("Academy Three");

        Set<Academy> academies = new HashSet<>();

        academies.addAll(Set.of(academy1, academy2, academy3));

        academyDAO.saveAll(academies);

        long count = academyDAO.count();

        assertEquals(3L, count);
    }

    @Test
    void deleteById() {

        Academy academy1 = new Academy("Academy One");

        academyDAO.save(academy1);

        academyDAO.existsById(1L);

        academyDAO.deleteById(1L);

        assertFalse(academyDAO.existsById(1L));
    }

    @Test
    void delete() {

        Academy academy3 = new Academy("Academy Three");

        academyDAO.save(academy3);

        academy3 = academyDAO.findById(1L).orElseThrow();

        academyDAO.delete(academy3);

        assertFalse(academyDAO.existsById(1L));
    }

    @Test
    void deleteAll() {

        Academy academy1 = new Academy("Academy One"), academy2 = new Academy("Academy Two");

        academyDAO.saveAll(Set.of(academy1, academy2));

        assertEquals(2L, academyDAO.count());

        academyDAO.deleteAll();

        assertEquals(0L, academyDAO.count());
    }

    @Test
    void deleteAllArgs() {

        Academy academy1 = new Academy("Academy One"),
            academy2 = new Academy("Academy Two"),
            academy3 = new Academy("Academy Three");

        Iterable<Academy> academies = academyDAO.saveAll(Set.of(academy1, academy2, academy3));

        assertEquals(3L, academyDAO.count());

        academyDAO.deleteAll(Streams.stream(academies)
                                    .limit(2L)
                                    .collect(Collectors.toSet()));

        assertEquals(1L, academyDAO.count());
    }

    @Test
    void course_DaoFindByField() {

        Academy academy3 = new Academy("Academy Three");

        Student student = new Student("Bruce", "Wayne", "bruce@wayne.com");

        Instructor instructor = new Instructor("Clark", "Kent", "kent@clark.com");

        Course course = new Course("Acoustics II", FieldOfStudy.PHYSICS, instructor, academy3);

        course.addStudent(student);

        courseDAO.save(course);

        Set<Course> courses1 = new HashSet<>();

        courseDAO.findByField(FieldOfStudy.PHYSICS)
                 .forEach(courses1::add);

        Course course2 = courses1.iterator().next();

        assertEquals(course2, course);
    }

    @Test
    void person_FindByRegistrationDateBetween() {

        Student student = new Student("Peter", "Parker", "spider@man.123");

        studentDAO.save(student);

        LocalDate now = LocalDate.now();

        student = studentDAO
            .findByRegistrationDateBetween(now.minus(1, DAYS), now.plus(1, DAYS))
            .iterator()
            .next();

        assertEquals("spider@man.123", student.getEmail());
    }

    @Test
    void person_FindByRegistrationDateAfter() {

        Instructor instructor1 = new Instructor("Peter", "Parker", "spider@man.123");

        Instructor instructor2 = new Instructor("Lois", "Lane", "lane_@lois.arg");

        instructorDAO.save(instructor1);

        instructorDAO.save(instructor2);

        Set<Instructor> instructors = Streams
            .stream(instructorDAO.findByRegistrationDateAfter(LocalDate.now().minus(1, DAYS)))
            .collect(Collectors.toSet());

        assertEquals(2, instructors.size());

        instructors = Streams
            .stream(instructorDAO.findByRegistrationDateAfter(LocalDate.now().plus(1, DAYS)))
            .collect(Collectors.toSet());

        assertEquals(0, instructors.size());
    }

    @Test
    void person_FindByRegistrationDateBefore() {

        Instructor instructor1 = new Instructor("Peter", "Parker", "spider@man.123");

        Instructor instructor2 = new Instructor("Lois", "Lane", "lane_@lois.arg");

        instructor1 = instructorDAO.save(instructor1);

        instructor2 = instructorDAO.save(instructor2);

        Set<Instructor> instructors = Streams
            .stream(instructorDAO.findByRegistrationDateBefore(LocalDate.now().plus(1, DAYS)))
            .collect(Collectors.toSet());

        assertEquals(2, instructors.size());

        instructors = Streams
            .stream(instructorDAO.findByRegistrationDateBefore(LocalDate.now().minus(1, DAYS)))
            .collect(Collectors.toSet());

        assertEquals(0, instructors.size());
    }
}