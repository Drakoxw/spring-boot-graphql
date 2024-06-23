package com.drako.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.drako.graphql.entities.Course;
import com.drako.graphql.entities.Student;
import com.drako.graphql.graphql.InputStudent;
import com.drako.graphql.service.ICourseService;
import com.drako.graphql.service.IStudentService;

@Controller
public class GrapQLStudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findStudenById")
    public Student findById(@Argument(name = "studentId") String id) {
        Long studentId = Long.parseLong(id);
        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @MutationMapping(name = "createStudent")
    public Student createStudent(@Argument(name = "inputStudent") InputStudent inputStudent) {

        Long courseId = Long.parseLong(inputStudent.getCourseId());
        Course course = courseService.findById(courseId);
        
        if (course == null) {
            return null;
        } 

        return studentService.createStudent(inputStudent, course);
    }
    
    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name = "studentId") String id) {
        Long studentId = Long.parseLong(id);
        studentService.deleteById(studentId);
        return String.format("Student with id: %s deleted", id);
    }

}
