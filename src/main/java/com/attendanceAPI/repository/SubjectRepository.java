package com.attendanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceAPI.models.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long>{

}
