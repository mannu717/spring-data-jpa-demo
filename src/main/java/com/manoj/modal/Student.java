package com.manoj.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "tbl_student_sequence",
            sequenceName = "tbl_student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbl_student_sequence"
    )
    private Long studentId;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(name = "email_address")
    private String emailId;

    @Column(length = 50)
    private String guardianName;

    @Column(length = 50)
    private String guardianPhone;

    @Column(name = "guardian_email_address")
    private String guardianEmail;
}
