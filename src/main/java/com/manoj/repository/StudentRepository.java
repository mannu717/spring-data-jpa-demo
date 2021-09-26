package com.manoj.repository;

import com.manoj.modal.Student;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Registered
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByLastNameNotNull();

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByGuardianNameIgnoreCase(String guardianName);

    //JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    //JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);

    //Native Query
    @Query(
            value = "SELECT * FROM tbl_student WHERE email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    //Native Query
    @Query(
            value = "SELECT first_name FROM tbl_student WHERE email_address = ?1",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailIdNative(String emailId);

    //Native Query Parameterized
    @Query(
            value = "SELECT * FROM tbl_student WHERE email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeParameterized(@Param("emailId") String emailId);

    //Native Query Parameterized
    @Query(
            value = "SELECT first_name FROM tbl_student WHERE email_address = :emailId",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailIdNativeParameterized(@Param("emailId") String emailId);

    //Native Update Query Parameterized
    @Transactional
    @Modifying
    @Query(
            value = "UPDATE tbl_student SET guardian_phone = :guardianPhone WHERE email_address = :emailId",
            nativeQuery = true
    )
    int updateGuardianPhoneByEmailIdNativeParameterized(@Param("guardianPhone") String guardianPhone, @Param("emailId") String emailId);
}
