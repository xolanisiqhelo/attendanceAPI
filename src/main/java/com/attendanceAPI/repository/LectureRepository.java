package com.attendanceAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceAPI.models.Lecture;
@Repository
public interface LectureRepository  extends JpaRepository<Lecture, Long>{
	Lecture	 findLectureBylectureNo(String lectureNo);

}
