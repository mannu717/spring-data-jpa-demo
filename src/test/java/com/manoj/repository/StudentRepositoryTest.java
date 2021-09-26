package com.manoj.repository;

import com.manoj.modal.Guardian;
import com.manoj.modal.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest() {
        Student student = Student.builder()
                .firstName("Manoj")
                .lastName("Bisht")
                .emailId("mannu717@gmail.com")
//                .guardianName("Laxman Singh")
//                .guardianPhone("999999999")
//                .guardianEmail("laxman@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianTest() {
        Guardian guardian = Guardian.builder()
                .name("Laxman Singh")
                .email("laxman@gmail.com")
                .phone("999999999")
                .build();

        Student student = Student.builder()
                .firstName("Pushkar")
                .lastName("Bisht")
                .emailId("pushkar@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findAllStudentTest() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void findByStudentFirstNameTest() {
        List<Student> studentList = studentRepository.findByFirstName("Manoj");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(1);
    }

    @Test
    public void findByStudentFirstContainingNameTest() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("a");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void findByStudentLastNameTest() {
        List<Student> studentList = studentRepository.findByLastName("Bisht");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void findByStudentLastNameNotNullTest() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void findByGuardianNameTest() {
        List<Student> studentList = studentRepository.findByGuardianName("Laxman Singh");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void findByGuardianNameIgnoreCaseTest() {
        List<Student> studentList = studentRepository.findByGuardianNameIgnoreCase("laxman singh");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void findByFirstNameAndLastNameTest() {
        List<Student> studentList = studentRepository.findByFirstNameAndLastName("Manoj", "Bisht");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(1);
    }

    @Test
    public void findByFirstNameOrLastNameTest() {
        List<Student> studentList = studentRepository.findByFirstNameOrLastName("Manoj", "Bisht");
        System.out.println(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void getStudentByEmailIdTest() {
        Student student = studentRepository.getStudentByEmailId("mannu717@gmail.com");
        System.out.println(student);
        assertThat(student.getFirstName()).isEqualTo("Manoj");
    }

    @Test
    public void getStudentFirstNameByEmailIdTest() {
        String studentName = studentRepository.getStudentFirstNameByEmailId("mannu717@gmail.com");
        System.out.println(studentName);
        assertThat(studentName).isEqualTo("Manoj");
    }

    @Test
    public void getStudentByEmailIdNativeTest() {
        Student student = studentRepository.getStudentByEmailIdNative("mannu717@gmail.com");
        System.out.println(student);
        assertThat(student.getFirstName()).isEqualTo("Manoj");
    }

    @Test
    public void getStudentFirstNameByEmailIdNativeTest() {
        String studentName = studentRepository.getStudentFirstNameByEmailIdNative("mannu717@gmail.com");
        System.out.println(studentName);
        assertThat(studentName).isEqualTo("Manoj");
    }

    @Test
    public void getStudentByEmailIdNativeParameterizedTest() {
        Student student = studentRepository.getStudentByEmailIdNativeParameterized("mannu717@gmail.com");
        System.out.println(student);
        assertThat(student.getFirstName()).isEqualTo("Manoj");
    }

    @Test
    public void getStudentFirstNameByEmailIdNativeParameterizedTest() {
        String studentName = studentRepository.getStudentFirstNameByEmailIdNativeParameterized("mannu717@gmail.com");
        System.out.println(studentName);
        assertThat(studentName).isEqualTo("Manoj");
    }

    @Test
    public void updateGuardianPhoneByEmailIdNativeParameterizedTest() {
        int count = studentRepository.updateGuardianPhoneByEmailIdNativeParameterized("9999999990", "mannu717@gmail.com");
        System.out.println(count);
        assertThat(count).isEqualTo(1);
    }

}