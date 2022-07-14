package com.greatlearning.debate.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}