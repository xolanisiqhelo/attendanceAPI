package com.attendanceAPI.service;


import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.Attandence;
import com.attendanceAPI.models.Lecture;
import com.attendanceAPI.models.Session;
import com.attendanceAPI.models.Slot;
import com.attendanceAPI.models.Student;
import com.attendanceAPI.models.Subject;
import com.attendanceAPI.models.TimeTable;
import com.attendanceAPI.repository.AttandenceRepository;
import com.attendanceAPI.repository.LectureRepository;
import com.attendanceAPI.repository.SessionRepository;
import com.attendanceAPI.repository.StudentRepository;
import com.attendanceAPI.repository.TimeTableRepository;

@Service
public class AttandenceService {

	@Autowired AttandenceRepository attandenceRepository;
	@Autowired StudentRepository registerRepository;
	@Autowired StartSessionService startSessionService;
	@Autowired StudentRepository studentRepository;
	@Autowired TimeTableRepository timeTableRepository;
    @Autowired SessionRepository sessionRepository;
    @Autowired LectureRepository lectureRepository;
	private Student  student1;
	 private Subject subject;


	private static final Logger logger=LoggerFactory.getLogger(AttandenceService.class);
	
	public Attandence saveAttandence(Attandence  attandence) 
	{
		logger.info("data info---->"+attandence.getStudentNo().toString());
		logger.info("sesion start number---->"+startSessionService.findStartSession("2020"));
		
		
		try {
			 Student student=studentRepository.findByStudentNo(attandence.getStudentNo());
			 Lecture lecture=lectureRepository.findLectureBylectureNo("2020");
			 Optional<TimeTable> tim=timeTableRepository.findById(lecture.getId());   
//			 if(student!=null)
//			 {
//				   List<Slot> arry=tim.get().getSlots();
//				   arry.forEach((rest)->
//				   {
//					    LocalTime startTime=LocalTime.parse(rest.getStartSession());
//					    LocalTime endTime=LocalTime.parse(rest.getEndSession());
//					    LocalTime time = LocalTime.now();
//						 if(time.isAfter(startTime)&&time.isBefore(endTime))
//				         {  this.subject=rest.getSubject();
//				         }
//				   });
//				 
//				   logger.info("runing subject1"+subject.getId());
//				   Session bySubjectID=sessionRepository.findBySubject_id(subject.getId());
//				   logger.info("runing subject"+bySubjectID	);
//				   List<Attandence>  attand=((Session) bySubjectID).getAttandences();
//				   logger.info("list"+attand);
////				   attand.add(attandence);
//				   return attandenceRepository.save(attandence);
//				 
//				 
//			 }else {
//				 logger.info("not found");
//				 return null;
//			 }
//			
//			studentRepository.findAll().forEach((result)->
//			{
//				student1=result;
//			});
//			if(student.getStudentNo().equals(attandence.getStudentNo()) )
//			{
//				List<Attandence> attand=startSessionService.findStartSession("2020");
//				attand.add(attandence);
//				return attandenceRepository.save(attandence);
//			}else
//			{
//				logger.info("nothing to save");
//				return null;	
//			}
			
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		return attandence;
	}
	
	public List<Attandence> ListAllUsers(){
		try {
			List<Attandence>attand=attandenceRepository.findAll();
			return attand;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public List<Attandence> findAllByStudentNo(String studentNo)
	{
		try {
			List<Attandence> studentrecord=attandenceRepository.findByStudentNo(studentNo);
			return  studentrecord;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}
}
