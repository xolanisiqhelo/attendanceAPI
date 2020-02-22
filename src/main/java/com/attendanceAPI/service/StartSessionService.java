package com.attendanceAPI.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceAPI.domain.SessionDao;
import com.attendanceAPI.mapper.SessionMapper;
import com.attendanceAPI.models.Attandence;
import com.attendanceAPI.models.Lecture;
import com.attendanceAPI.models.Session;
import com.attendanceAPI.models.Slot;
import com.attendanceAPI.models.Subject;
import com.attendanceAPI.models.TimeTable;
import com.attendanceAPI.repository.LectureRepository;
import com.attendanceAPI.repository.SessionRepository;
import com.attendanceAPI.repository.SubjectRepository;
import com.attendanceAPI.repository.TimeTableRepository;

import fr.xebia.extras.selma.Selma;

@Service
public class StartSessionService {
	private static final Logger logger = LoggerFactory.getLogger(StartSessionService.class);
	@Autowired
	LectureRepository lectureRepository;
	@Autowired
	TimeTableRepository timeTableRepository;
	@Autowired
	SessionRepository sessionRepository;
	private SessionMapper mapper = Selma.builder(SessionMapper.class).build();
	@Autowired
	SubjectRepository subjectRepository;
	private Subject subject;
	private int count = 0;

	public Session findStartSession(String lectureNo) {
		count = count + 1;
		List<Attandence> attandences = new ArrayList<>();
		try {
			Lecture lecture = lectureRepository.findLectureBylectureNo(lectureNo);
			Optional<TimeTable> tim = timeTableRepository.findById(lecture.getId());

			List<Slot> arry = tim.get().getSlots();
			arry.forEach((rest) -> {
				LocalTime startTime = LocalTime.parse(rest.getStartSession());
				LocalTime endTime = LocalTime.parse(rest.getEndSession());
				LocalTime time = LocalTime.now();
				if (time.isAfter(startTime) && time.isBefore(endTime)) {
					this.subject = rest.getSubject();
				}
			});
			Session session = new Session();
			session.setSubject(subject);
			session.setStatus(true);
			session.setSessionStartNo(lectureNo);
			session.setAttandences(attandences);
			session.setCount(count);
			Session bySubjectID = sessionRepository.findBySubject_id(session.getSubject().getId());
			logger.info("session  object" + bySubjectID);
			if (bySubjectID != null) {
				Optional<Session> sess = sessionRepository.findById(bySubjectID.getId());
				SessionDao dd = new SessionDao();
				dd.setCount(count);
				dd.setStatus(true);
				if (sess.isPresent() && sess != null) {
					Session updateSesion = mapper.updateSession(dd, sess.get());
					logger.info("UpdatedSession" + updateSesion);
					Session ses = sessionRepository.save(updateSesion);
					SessionDao updateDao = mapper.asSessionDao(ses);
					return session;
				} else {
					Session ses = sessionRepository.save(session);
					return ses;
				}

			} else {
				Session ses = sessionRepository.save(session);
				return ses;

			}

		} catch (Exception e) {
			throw e;
		}
	}

	public List<Session> listAll() {

		List<Session> session = sessionRepository.findAll();
		return session;

	}

}
