package com.drako.graphql.service;

import java.util.List;

import com.drako.graphql.entities.Course;

public interface ICourseService {

    Course findById(Long id);

    List<Course> findAll();

    Course createCourse(Course course);

    void deleteById(Long id);
}
