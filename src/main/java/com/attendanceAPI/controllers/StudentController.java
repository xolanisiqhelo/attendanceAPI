package com.attendanceAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.attendanceAPI.models.Student;
import com.attendanceAPI.service.StudentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value ="student information",description = "student information for  all user in the system")
public class StudentController {

	private static Logger logger=LoggerFactory.getLogger(StudentController.class);
	@Autowired StudentService registerService;
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Object> saveStudent(@RequestBody(required = true) Student student)
	{
		try {
			logger.info("student ifomation---->"+student);
			return new ResponseEntity<>(registerService.registerStudent(student),HttpStatus.OK);
			
			
		} catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}
}
