package com.attendanceAPI.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.Lecture;
import com.attendanceAPI.repository.LectureRepository;

@Service
public class LectureService {

	@Autowired LectureRepository lectureRepository;
	
	public Lecture saveLuctureInformation(Lecture lecture)
	{
		try {
			return lectureRepository.save(lecture);
			
		} catch (Exception e) {
	
			throw e;
		}
	}
	public List<Lecture>listAllLecture()
	{
		try {
			List<Lecture> lect=lectureRepository.findAll();
			return  lect;
			
		} catch (Exception e) {
		
			throw e;
		}
	}
	public Optional<Lecture> findLectureByID(Integer id)
	{
		try {
			Optional<Lecture> lect=lectureRepository.findById(id);
			return lect;
			
		} catch (Exception e) {
		
			throw e;
		}
	}
}
