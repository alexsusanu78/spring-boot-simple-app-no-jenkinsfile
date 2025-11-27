package com.wasim.rest.api.service;

import java.util.List;

import com.wasim.rest.api.entity.Student;

public interface StudentService {

	Student create(Student student);
	
	List<Student> getAll();
	
	Student update(long id, Student student);
	
	void delete(long id);
}
