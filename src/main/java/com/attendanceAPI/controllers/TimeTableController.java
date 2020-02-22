package com.attendanceAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceAPI.models.TimeTable;
import com.attendanceAPI.service.TimeTableService;


@RestController
@RequestMapping("/api/v1")
public class TimeTableController {

//	private static Logger logger=LoggerFactory.getLogger(StudentController.class);
	@Autowired TimeTableService timeTableService;
	
	
	@RequestMapping(value = "/timetable", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Object> createTimeTable(@RequestBody(required=true) TimeTable timeTable)
	{
		try {
//			logger.info("time table--->"+timeTable);
			return new ResponseEntity<Object>(timeTableService.create(timeTable),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	@RequestMapping(value = "/ListTimeTable", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Object>List(){
			try {
				return new ResponseEntity<>(timeTableService.ListAll(),HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
				
			}
	}
	
	@RequestMapping(value = "/ListTimeTable{id}", method = RequestMethod.GET,produces = "application/json")
	public  ResponseEntity<Object>ListById(@RequestParam(required=true)Integer id)
	{
		try {
			
			return new ResponseEntity<>(timeTableService.findLectureById(id),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
}
