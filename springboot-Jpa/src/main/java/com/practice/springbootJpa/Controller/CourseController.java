package com.practice.springbootJpa.Controller;

import com.practice.springbootJpa.Entity.Course;
import com.practice.springbootJpa.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepo repo;

    @RequestMapping("/saveCourse")
    public Course save(@RequestBody Course course){
        repo.save(course);
        return course;
    }

    @GetMapping("/getAllCourses")
    public List<Course> get(){
        List<Course> courses =repo.findAll();
        return courses;
    }

}
