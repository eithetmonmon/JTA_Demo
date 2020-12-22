package com.may.phyo.db.student.dao;

import com.may.phyo.db.student.ds.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<Student,Integer> {
}
