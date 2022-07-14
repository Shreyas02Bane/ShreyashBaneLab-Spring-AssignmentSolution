package com.greatlearning.debate.service;

import java.util.List;

import com.greatlearning.debate.entity.Student;

public interface IStudentService {

	public Student createStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(Long studentIdL);

	public void deleteStudent(Long studentIdL);

	public Student updateStudent(Student student, long studentId);
}