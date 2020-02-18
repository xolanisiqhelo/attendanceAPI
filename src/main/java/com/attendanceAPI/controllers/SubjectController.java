package com.attendanceAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceAPI.models.Subject;
import com.attendanceAPI.service.SubjectService;

@RestController
@RequestMapping("/api/v1")
public class SubjectController {
	
	
	private static Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired private SubjectService  subjectService;
	
	@RequestMapping(value = "/subject", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Object> createSubject(@RequestBody(required=true) Subject subject)
	{
		try {
			logger.info("subject------->"+subject);
			return new ResponseEntity<>(subjectService.saveSubjects(subject),HttpStatus.OK);
			
		} catch (Exception e) {
			return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
			
		}
	}
	@RequestMapping(value = "/listSubject", method = RequestMethod.GET,produces = "application/json")
	public  ResponseEntity<Object>list(){
		try {
			return new ResponseEntity<Object>(subjectService.ListAllSubjects(),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	@RequestMapping(value = "/listSubject{id}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Object>ListById(@RequestParam(required=true)long id)
	{
		try {
			return new ResponseEntity<Object>(subjectService.findSubjectById(id),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	
}
