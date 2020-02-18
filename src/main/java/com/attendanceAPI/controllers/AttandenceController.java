package com.attendanceAPI.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceAPI.models.Attandence;
import com.attendanceAPI.service.AttandenceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value ="attandence student information",description = " attandence student information for  all user in the system")
public class AttandenceController {

	@Autowired AttandenceService attandenceService;
	
	private static final Logger logger=LoggerFactory.getLogger(AttandenceController.class);
	@RequestMapping(value = "/attandence", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> saveStudent(@RequestBody (required = true) Attandence attandence)
	{
		try {
			logger.info("student ifomation---->"+attandence);
			return new ResponseEntity<>(attandenceService.saveAttandence(attandence),HttpStatus.OK);
			
			
		} catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}
	@RequestMapping(value = "/List", method = RequestMethod.GET, produces = "application/json")
	public  ResponseEntity<Object>List(){
		try {
			
			return new ResponseEntity<>(attandenceService.ListAllUsers(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	@RequestMapping(value = "/List/{studentNo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object>ListByStudentNo(String studentNo)
	{
		try {
			return new ResponseEntity<>(attandenceService.findAllByStudentNo(studentNo),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	
}
