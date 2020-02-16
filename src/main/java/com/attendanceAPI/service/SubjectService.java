package com.attendanceAPI.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.Subject;
import com.attendanceAPI.repository.SubjectRepository;

@Service
public class SubjectService {
	
	private static final Logger logger=LoggerFactory.getLogger(SubjectService.class);
	@Autowired private SubjectRepository subjectRepository;
	
	public Subject saveSubjects(Subject subject)
	{
		try {
			logger.info("service information for subject------->"+subject);
			return subjectRepository.save(subject);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public List<Subject>ListAllSubjects()
	{
		try {
			List<Subject>sub=subjectRepository.findAll();
			return sub;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public Optional<Subject> findSubjectById(long id)
	{
		try {
			Optional<Subject>sub =subjectRepository.findById(id);
					return sub;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
