package com.practice.springbootJpa.Repository;

import com.practice.springbootJpa.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    public Student findByFirstName(String name);

    public List<Student> findByLastNameContaining(String name);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student getByEmailId(String email);

    //Native Query
    @Query(value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getByEmailIdNative(String emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set email_address =:email where first_name=:name",
            nativeQuery = true
    )
    public void updateEmailUsingName(String email , String name);
}
