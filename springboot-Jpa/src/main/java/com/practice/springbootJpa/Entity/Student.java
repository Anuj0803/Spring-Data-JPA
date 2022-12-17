package com.practice.springbootJpa.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Id
    private int studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Parent parent;



}
