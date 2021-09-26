package com.manoj.repository;

import com.manoj.modal.Course;
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
}