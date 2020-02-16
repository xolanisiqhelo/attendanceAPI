package com.attendanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceAPI.models.Session;
@Repository
public interface SessionRepository  extends JpaRepository<Session, Long>{

}
