package com.practice.springbootJpa.Controller;

import com.practice.springbootJpa.Entity.Student;
import com.practice.springbootJpa.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;

    @RequestMapping("/save")
    public Student save(@RequestBody Student student){
        repo.save(student);
        return student;
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        List<Student> students =repo.findAll();
        return students;
    }

    @GetMapping("/get/{id}")
    public Student getById(@PathVariable int id){
        Student student =(Student) repo.findById(id).orElse(null);
        return student;
    }

    @GetMapping("/getName/{name}")
    public Student getByName(@PathVariable String name){
        Student student = (Student) repo.findByFirstName(name);
        return student;
    }

    @GetMapping("/LastName/{name}")
    public List<Student> getByLatNameContaining(@PathVariable String name){
        List<Student> students = repo.findByLastNameContaining(name);
        return students;
    }

    @GetMapping("/email/{email}")
    public Student getByEmail(@PathVariable String email){
      Student student = (Student)repo.getByEmailId(email);
        return student;
    }

    @GetMapping("/emailN/{email}")
    public Student getByEmailNative(@PathVariable String email){
        Student student = (Student)repo.getByEmailIdNative(email);
        return student;
    }

    @RequestMapping("/update/{email}/{name}")
    public void update(@PathVariable(name = "email") String email , @PathVariable (name = "name") String name){
        repo.updateEmailUsingName(email,name);
    }
}
