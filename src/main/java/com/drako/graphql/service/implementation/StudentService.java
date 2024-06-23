package com.drako.graphql.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drako.graphql.entities.Course;
import com.drako.graphql.entities.Student;
import com.drako.graphql.graphql.InputStudent;
import com.drako.graphql.persistence.IStudentDAO;
import com.drako.graphql.service.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    @Transactional(readOnly = true)
    public Student findById(long id) {
        return studentDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student createStudent(InputStudent input, Course course) {
        
        Student student = new Student();
        student.setName(input.getName());
        student.setLastName(input.getLastName());
        student.setAge(input.getAge());
        student.setCourse(course);

        return studentDAO.save(student);   
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        studentDAO.deleteById(id);
    }

}
