package com.manoj.repository;

import com.manoj.modal.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findAllCoursesTest() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacherTest() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentTestAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Swati")
                .lastName("Singh")
                .build();

        Student student = Student.builder()
                .firstName("Rahul")
                .lastName("Kumar")
                .emailId("rahul@gmail.com")
                .guardian(Guardian.builder()
                        .name("Rakesh")
                        .email("rakesh@gmail.com")
                        .phone("999999000")
                        .build())
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(6)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        courseRepository.save(course);
    }
}