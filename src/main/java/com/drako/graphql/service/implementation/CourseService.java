package com.drako.graphql.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drako.graphql.entities.Course;
import com.drako.graphql.persistence.ICourseDAO;
import com.drako.graphql.service.ICourseService;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDAO courseDAO;

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseDAO.findAll();
    }

    @Override
    @Transactional
    public Course createCourse(Course course) {
        return courseDAO.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseDAO.deleteById(id);
    }

}
