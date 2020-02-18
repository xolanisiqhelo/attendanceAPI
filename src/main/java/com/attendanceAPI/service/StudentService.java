package com.attendanceAPI.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.Student;
import com.attendanceAPI.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired  StudentRepository registerRepository;
	
	private static Logger logger=LoggerFactory.getLogger(StudentService.class);
	
	public Student registerStudent(Student  register) {
		
		try {
			return registerRepository.save(register);
			
		} catch (Exception e) {
			logger.info("coudn't register"+e.getMessage());
			throw e;
		}
		
	}

}
