package com.greatlearning.debate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debate.entity.Student;
import com.greatlearning.debate.repos.IStudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentRepository studentRegistratonRepository;

	@Transactional
	public Student createStudent(Student student) {
		Student saveStudent = studentRegistratonRepository.save(student);
		return saveStudent;
	}

	public List<Student> getAllStudent() {
		return studentRegistratonRepository.findAll();
	}

	public Student getStudentById(Long studentIdL) {

		return studentRegistratonRepository.findById(studentIdL)
				.orElseThrow(() -> new IllegalArgumentException("No student found."));
	}

	@Transactional
	public void deleteStudent(Long studentIdL) {
		studentRegistratonRepository.deleteById(studentIdL);
	}

	@Transactional
	public Student updateStudent(Student student, long studentId) {
		return studentRegistratonRepository.save(student);
	}

}