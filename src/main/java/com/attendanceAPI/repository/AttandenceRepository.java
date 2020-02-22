package com.attendanceAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceAPI.models.Attandence;
@Repository
public interface AttandenceRepository extends JpaRepository<Attandence, Integer> {

	List<Attandence> findByStudentNo(String StudentNo);

	Attandence save(List<Attandence> attand);




}
