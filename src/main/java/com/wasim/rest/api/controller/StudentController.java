package com.wasim.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wasim.rest.api.entity.Student;
import com.wasim.rest.api.service.StudentService;

@RestController
@RequestMapping("/student/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> create(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") long id, @RequestBody Student student) {
		return new ResponseEntity<>(studentService.update(id, student), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		studentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
