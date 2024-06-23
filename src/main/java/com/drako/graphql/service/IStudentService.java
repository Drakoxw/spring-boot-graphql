package com.drako.graphql.service;

import java.util.List;

import com.drako.graphql.entities.Course;
import com.drako.graphql.entities.Student;
import com.drako.graphql.graphql.InputStudent;

public interface IStudentService {

    Student findById(long id);

    List<Student> findAll();

    Student createStudent(InputStudent input, Course course);

    void deleteById(long id);
}
