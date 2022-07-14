package com.greatlearning.debate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.greatlearning.debate.entity.Student;
import com.greatlearning.debate.service.IStudentService;

@Controller
//@RestController
@RequestMapping("/Student")
//@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private IStudentService studentRegistration;

	/*---------------------------------POSTMAN--LAYER----------------------------------------------------------*/
//	@RequestMapping(path="/",method = RequestMethod.GET)
	@GetMapping
	public List<Student> viewAllStudent() {
		return studentRegistration.getAllStudent();
	}

//	@RequestMapping(path="/",method = RequestMethod.POST)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		return studentRegistration.createStudent(student);
	}

//	@RequestMapping(path="/update/{studentId}",method = RequestMethod.PUT)
	@PutMapping("/{studentId}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
		return studentRegistration.updateStudent(student, studentId);
	}

	// @RequestMapping(path="/delete/{studentId}",method = RequestMethod.DELETE)
	@DeleteMapping("/{studentId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentRegistration.deleteStudent(studentId);
	}

//	@RequestMapping(path = "/read/{studentId}", method = RequestMethod.GET)
	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable("studentId") Long studentId) {
		return studentRegistration.getStudentById(studentId);

	}
	/*----------------------------------------END----------------------------------------------------------------*/

	/*-------------------------------------VIEW--LAYER------------------------------------------------------------*/

	// view to registered students or the main page
	@RequestMapping(path = "/view-students", method = RequestMethod.GET)
	public ModelAndView viewRegisterdStudent(ModelAndView m) {
		List<Student> students = studentRegistration.getAllStudent();
		m.addObject("students", students);
		m.setViewName("student_list");
		return m;
	}

	// view to student registration form
	@RequestMapping(path = "/registeration_form", method = RequestMethod.GET)
	public String viewStudentForm(Model m) {
		m.addAttribute("title", "Register Student");
		return "registeration_form";
	}

	// save student details by form in view
	@RequestMapping(path = "/handle-studentRegister", method = RequestMethod.POST)
	public RedirectView studentHandler(@ModelAttribute Student student, HttpServletRequest request) {
		RedirectView redirect = new RedirectView();
		studentRegistration.createStudent(student);
		redirect.setUrl(request.getContextPath() + "/Student/view-students");
		return redirect;
	}

	// delete student details from the view student form
	@RequestMapping(path = "/delete", method = RequestMethod.GET)
		public String deleteStudentList(@RequestParam("id") Long id) {
		System.out.println("Student Id for delete :" + id);
		studentRegistration.deleteStudent(id);
		return "redirect:/Student/view-students";
	}
	//calling the update form
	@RequestMapping(path="/updateForm" ,method = RequestMethod.GET)
	public String updateStudentForm(Model m,@RequestParam("id") Long id) {
		m.addAttribute("title", "Update Student");
		
		Student student = studentRegistration.getStudentById(id);
		System.out.println(student.toString());
		m.addAttribute("student", student);
		return "updation_form";
	}
	//Updating the student details
	@RequestMapping(path="/handle-studentUpdation/{id}",method = RequestMethod.POST)
	public String updateHandler(@ModelAttribute Student student,@RequestParam("id") Long id) {
		studentRegistration.updateStudent(student, id);
		return "redirect:/Student/view-students";
	}
	
}