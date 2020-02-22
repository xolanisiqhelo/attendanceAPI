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

import com.attendanceAPI.models.Lecture;
import com.attendanceAPI.service.LectureService;

@RestController
@RequestMapping("/api/v1")
public class LectureController {

	@Autowired LectureService lectureService;

	private static final Logger logger=LoggerFactory.getLogger(LectureController.class);
	@RequestMapping(value = "/lecture", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> createLecture(@RequestBody(required=true)Lecture lecture )
	{
		try {
			logger.info("leccture info--->"+lecture);
			return new ResponseEntity<>(lectureService.saveLuctureInformation(lecture),HttpStatus.OK);
		} catch (Exception e) {
			
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}
	@RequestMapping(value = "/listLecture", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object>Lists()
	{
		try {
			
			return new ResponseEntity<>(lectureService.listAllLecture(),HttpStatus.OK);
		} catch (Exception e) {

			return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	@RequestMapping(value = "/listLecture{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object>listById(@RequestParam(required=true) Integer id)
	{
		try {
			return new  ResponseEntity<Object>(lectureService.findLectureByID(id),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	
	
}
