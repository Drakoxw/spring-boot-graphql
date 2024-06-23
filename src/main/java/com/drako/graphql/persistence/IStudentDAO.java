package com.drako.graphql.persistence;

import org.springframework.data.repository.CrudRepository;
import com.drako.graphql.entities.Student;

public interface IStudentDAO extends CrudRepository<Student, Long> {
}
