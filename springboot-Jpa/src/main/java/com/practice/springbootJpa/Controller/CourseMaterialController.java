package com.practice.springbootJpa.Controller;

import com.practice.springbootJpa.Entity.CourseMaterial;
import com.practice.springbootJpa.Repository.CourseMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseMaterialController {

    @Autowired
    CourseMaterialRepo repo;

    @RequestMapping("/saveMaterial")
    public CourseMaterial save(@RequestBody CourseMaterial courseMaterial){
        repo.save(courseMaterial);
        return courseMaterial;
    }

    @RequestMapping("/gatAllMaterial")
    public List<CourseMaterial> get(){
        List<CourseMaterial> courseMaterial= repo.findAll();
        return courseMaterial;
    }
}
