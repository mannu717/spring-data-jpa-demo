package com.manoj.repository;

import com.manoj.modal.Student;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface StudentRepository extends JpaRepository<Student, Long> {
}
