package com.attendanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.attendanceAPI.models.Student;

@Repository
public interface  StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentNo(String string);
}