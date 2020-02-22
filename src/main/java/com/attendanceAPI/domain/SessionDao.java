package com.attendanceAPI.domain;

import java.util.List;



import com.attendanceAPI.models.Attandence;
import com.attendanceAPI.models.Subject;
import com.google.gson.Gson;


public class SessionDao {
	private Integer id;
	private String SessionStartNo;
	private  Subject subject;
    private boolean status;	
	private List<Attandence> attandences;
	private int count;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSessionStartNo() {
		return SessionStartNo;
	}
	public void setSessionStartNo(String sessionStartNo) {
		SessionStartNo = sessionStartNo;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Attandence> getAttandences() {
		return attandences;
	}
	public void setAttandences(List<Attandence> attandences) {
		this.attandences = attandences;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
