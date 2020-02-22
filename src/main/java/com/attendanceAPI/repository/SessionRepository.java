package com.attendanceAPI.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceAPI.models.Session;

@Repository
public interface SessionRepository  extends JpaRepository<Session, Integer>{
	
//	Optional<Session> findBySubject_id(Integer integer);
	Session findBySubject_id(Integer integer);

	

}
