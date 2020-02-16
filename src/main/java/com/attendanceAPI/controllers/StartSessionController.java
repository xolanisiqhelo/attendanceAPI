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

import com.attendanceAPI.models.Session;
import com.attendanceAPI.service.StartSessionService;


@RestController
@RequestMapping("/api/v1")
public class StartSessionController {

    @Autowired StartSessionService startSessionService;
    private static final Logger logger =LoggerFactory.getLogger(StartSessionController.class);
    
	@RequestMapping(value = "/startSession", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> startSession(@RequestParam(required=true) String lectureNo)
	{
		try {
			
			return new ResponseEntity<>(startSessionService.findStartSession(lectureNo),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);

		}
	}
//	@RequestMapping(value = "/createAttandance", method = RequestMethod.POST, produces = "application/json")
//	public ResponseEntity<Object> createAttandances(@RequestBody(required=true) Session session)
//	{
//		try {
//			
//			logger.info("creating session information---->"+session);
//			return new ResponseEntity<>(startSessionService.createSession(session),HttpStatus.OK);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
//
//		}
//	}
}