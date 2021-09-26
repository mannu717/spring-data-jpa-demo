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
@Table(
        name = "tbl_course"
)
public class Course {

    @Id
    @SequenceGenerator(
            name = "tbl_course_sequence",
            sequenceName = "tbl_course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbl_course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;
}
