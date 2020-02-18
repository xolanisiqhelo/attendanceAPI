package com.attendanceAPI.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.Attandence;
import com.attendanceAPI.models.Lecture;
import com.attendanceAPI.models.Session;
import com.attendanceAPI.models.Slot;
import com.attendanceAPI.models.Subject;
import com.attendanceAPI.models.TimeTable;
import com.attendanceAPI.repository.LectureRepository;
import com.attendanceAPI.repository.SessionRepository;
import com.attendanceAPI.repository.TimeTableRepository;

@Service
public class StartSessionService {
//	private static final Logger logger=LoggerFactory.getLogger(StartSessionService.class);
	@Autowired LectureRepository lectureRepository;
	@Autowired TimeTableRepository timeTableRepository;
    @Autowired SessionRepository sessionRepository;
    private Subject subject;	
    private String subjectCode;
	
	public List<Attandence> findStartSession(String lectureNo) 
	{
		List<Attandence>attandences =  new ArrayList<>();
		try {			
			Lecture lecture=lectureRepository.findLectureBylectureNo(lectureNo);
		    Optional<TimeTable> tim=timeTableRepository.findById(lecture.getId());   
		    
		   List<Slot> arry=tim.get().getSlots();
		   arry.forEach((rest)->
		   {
			    LocalTime startTime=LocalTime.parse(rest.getStartSession());
			    LocalTime endTime=LocalTime.parse(rest.getEndSession());
			    LocalTime time = LocalTime.now();
				 if(time.isAfter(startTime)&&time.isBefore(endTime))
		         {  this.subject=rest.getSubject();
		         }
		   });
	    	 Session session=new Session();
	    	 session.setSubject(subject);
	    	 session.setAttandences(attandences);
	    	 sessionRepository.findAll().forEach((result)->
	    	 {
	    		 subjectCode=result.getSubject().getSubjectCode();
	    	 });
	    	 if(subjectCode!=session.getSubject().getSubjectCode())
    		 {
    	    	 Session ses=sessionRepository.save(session);
    	    	 return  ses.getAttandences();
    		 }else{return null;}

		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
	public List<Session> listAll(){
		
		List<Session>  session=sessionRepository.findAll();
		return session;
				
	}


}
