package com.practice.springbootJpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseMaterialId;
    private String url ;

    @OneToOne
    @JoinColumn(name = "course_id",
    referencedColumnName = "courseId"
    )
    private Course course;
}
