package com.manoj.repository;

import com.manoj.modal.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPageTest() {
        Pageable firstPageWithThreeRecord = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecord = PageRequest.of(1, 2);

        Page<Course> firstPageRecord = courseRepository.findAll(firstPageWithThreeRecord);
        System.out.println(firstPageRecord.getTotalPages());
        System.out.println(firstPageRecord.getTotalElements());
        System.out.println(firstPageRecord.getContent());

        Page<Course> secondPageRecord = courseRepository.findAll(secondPageWithTwoRecord);
        System.out.println(secondPageRecord.getTotalPages());
        System.out.println(secondPageRecord.getTotalElements());
        System.out.println(secondPageRecord.getContent());

    }

    @Test
    public void findAllSortTest() {
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );
        Pageable sortByCredit = PageRequest.of(
                1,
                2,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCredit = PageRequest.of(
                1,
                2,
                Sort.by("title")
                        .descending()
                        .and(
                                Sort.by("credit")
                        )
        );

        Page<Course> sortByTitleRecord = courseRepository.findAll(sortByTitle);
        System.out.println("totalPage: " + sortByTitleRecord.getTotalPages());
        System.out.println("totalElement: " + sortByTitleRecord.getTotalElements());
        System.out.println("sortByTitleRecord content: " + sortByTitleRecord.getContent());

        Page<Course> sortByCreditRecord = courseRepository.findAll(sortByCredit);
        System.out.println("totalPage: " + sortByCreditRecord.getTotalPages());
        System.out.println("totalElement: " + sortByCreditRecord.getTotalElements());
        System.out.println("sortByCreditRecord content: " + sortByCreditRecord.getContent());

        Page<Course> sortByTitleAndCreditRecord = courseRepository.findAll(sortByTitleAndCredit);
        System.out.println("totalPage: " + sortByTitleAndCreditRecord.getTotalPages());
        System.out.println("totalElement: " + sortByTitleAndCreditRecord.getTotalElements());
        System.out.println("sortByTitleAndCreditRecord content: " + sortByTitleAndCreditRecord.getContent());

    }

    @Test
    public void findByTitleContainingPageTest() {
        Pageable pageContainingTitle = PageRequest.of(
                0,
                2
        );

        Page<Course> pageContainingTitleRecord = courseRepository.findByTitleContaining("A", pageContainingTitle);
        System.out.println("totalPage: " + pageContainingTitleRecord.getTotalPages());
        System.out.println("totalElement: " + pageContainingTitleRecord.getTotalElements());
        System.out.println("pageContainingTitleRecord content: " + pageContainingTitleRecord.getContent());
    }
}