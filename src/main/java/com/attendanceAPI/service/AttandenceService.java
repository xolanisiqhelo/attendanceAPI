package com.attendanceAPI.service;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.Attandence;
import com.attendanceAPI.repository.AttandenceRepository;
import com.attendanceAPI.repository.StudentRepository;

@Service
public class AttandenceService {

	@Autowired AttandenceRepository attandenceRepository;
	@Autowired StudentRepository registerRepository;
	@Autowired StartSessionService startSessionService;

	private static final Logger logger=LoggerFactory.getLogger(AttandenceService.class);
	
	public Attandence saveAttandence(Attandence  attandence ) 
	{
	
//		logger.info("data info---->"+attandence.getStudentNo().toString());
		try {
//			if(registerRepository.findByStudentNo(attandence.getStudentNo().toString())!=null)
//			{
				
	
				List<Attandence> attand=startSessionService.findStartSession("2020");
				logger.info("save student number---->"+attand);
				attand.add(attandence);
				logger.info("save student number----1111>"+attand.add(attandence));
			
				return attandenceRepository.save(attandence);
	
//			}else
//			{
//				logger.info("nothing to save");
//				return null;
//			}
			
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
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
			logger.info("record for specific student per day---->");
			List<Attandence> studentrecord=attandenceRepository.findByStudentNo(studentNo);
			logger.info("record for specific student per dayjsavdsahDVKHV---->"+studentrecord);
			return  studentrecord;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}
}
