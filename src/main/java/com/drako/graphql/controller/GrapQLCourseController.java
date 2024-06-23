package com.drako.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.drako.graphql.entities.Course;
import com.drako.graphql.graphql.InputCourse;
import com.drako.graphql.service.ICourseService;

@Controller
public class GrapQLCourseController {

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id) {
        Long courseId = Long.parseLong(id);
        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @MutationMapping(name = "createCourse")
    public Course createCourse(@Argument(name = "input") InputCourse input) {
        Course course = new Course();
        course.setName(input.getName());
        course.setCategory(input.getCategory());
        course.setTeacher(input.getTeacher());

        courseService.createCourse(course);
        return course;
    }

    @MutationMapping(name = "deleteCourse")
    public String deleteCourse(@Argument(name = "courseId") String id) {
        Long courseId = Long.parseLong(id);
        courseService.deleteById(courseId);
        return String.format("Course with id: %s deleted", id);
    }

}
