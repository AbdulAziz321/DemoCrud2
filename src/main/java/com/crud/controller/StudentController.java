package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.exception.StudentNotFoundException;
import com.crud.model.Student;
import com.crud.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/home")
	public String getStudent(Model model) {
		List<Student> student = studentService.getAllStudents();
		model.addAttribute("stud",student);	
		return "index";
	}
	
	@GetMapping("/update")
	public String UpdateStudentList(Model model) {
		List<Student> student = studentService.getAllStudents();
		model.addAttribute("stud",student);	
		return "UpdateFrom";
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(Model model,@PathVariable long id) {
		Student student = studentService.getById(id);
		model.addAttribute("stud",student);
		return "updateStudent";
	}
	
	
	@PostMapping("/updatestudent/{id}")
	public String updateString(@ModelAttribute("stud") Student student,@PathVariable long id) {	
		studentService.updateStudent(student,id);
		return "redirect:/student/home";	
	}
	
	
	@GetMapping("/delete")
	public String deleString(Model model) {
		List<Student> student = studentService.getAllStudents();
		model.addAttribute("stud",student);
		return "Delete";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deteleStudent(@PathVariable long id) {
		studentService.deleteById(id);
		return "redirect:/student/home";
	}
	
	@GetMapping("/save")
	public String saveStudent(Model model , Student student){
		model.addAttribute("stud",student);
		return "InsertStudent";
	}
	
	@PostMapping(path = "/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("stud") Student student , BindingResult result) {
		if (result.hasErrors()) {
		    return "InsertStudent";
		  }
		studentService.saveStudent(student);
		return "redirect:/student/home";
	}
	
	
	@GetMapping("/searchStudent")
	public String getSearch(@RequestParam("search") String search,Model model) {
		List<Student> sList = studentService.getSearch(search);
		if (sList.isEmpty()) {
			return "error";
		}else {
			model.addAttribute("stud", sList);
			return "Search";
		}
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public String handleError(Model model,RuntimeException ex){
		model.addAttribute("error",ex.getMessage());
		return "error";
	}
	
}
