package com.drako.graphql.persistence;

import org.springframework.data.repository.CrudRepository;
import com.drako.graphql.entities.Course;

public interface ICourseDAO extends CrudRepository<Course, Long> {}
