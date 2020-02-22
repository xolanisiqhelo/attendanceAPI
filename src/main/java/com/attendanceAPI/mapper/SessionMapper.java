package com.attendanceAPI.mapper;

import com.attendanceAPI.domain.SessionDao;
import com.attendanceAPI.models.Session;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;



@Mapper(
        withIgnoreMissing = IgnoreMissing.ALL,
        withIgnoreNullValue = true
)
public interface SessionMapper {
//	Session  updateSession(int i,Session out);
	SessionDao asSessionDao(Session in);
	Session asSession(SessionDao in);
	Session updateSession(SessionDao session, Session out);
}
