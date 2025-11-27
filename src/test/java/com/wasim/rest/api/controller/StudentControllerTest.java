package com.wasim.rest.api.controller;

import com.wasim.rest.api.entity.Student;
import com.wasim.rest.api.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void testGetAllStudents() throws Exception {
        List<Student> students = Arrays.asList(
            new Student(1L, "John", "Doe", ""),
            new Student(2L, "Anna", "Smith", "")
        );

        when(studentService.getAll()).thenReturn(students);

        mockMvc.perform(get("/student/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }
}