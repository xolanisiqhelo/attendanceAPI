package com.attendanceAPI.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.models.TimeTable;
import com.attendanceAPI.repository.TimeTableRepository;

@Service
public class TimeTableService {

	private static final Logger logger=LoggerFactory.getLogger(TimeTableService.class);
	@Autowired private TimeTableRepository timeTableRepository;
	
	
	public TimeTable create(TimeTable timetable) throws SQLException, Exception{
		try {
			TimeTable savedTimeTable = timeTableRepository.save(timetable);
			
			if(savedTimeTable == null) {
				throw new Exception("Failed to save timetable");
			}
			
			return savedTimeTable;			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public List<TimeTable>ListAll()
	{
		try {
			List<TimeTable>tt=timeTableRepository.findAll();
			return tt;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Optional<TimeTable> findLectureById(Integer id)
	{
		try {
			
			Optional<TimeTable>startTime=timeTableRepository.findById(id);
			logger.info("sessions service--->"+startTime);

			return  startTime;
		} catch (Exception e) {
			throw e;
		}
	}
}
