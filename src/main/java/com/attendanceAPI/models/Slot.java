package com.attendanceAPI.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name="slot")
public class Slot {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int slotNumber;
	@Column(name = "start_session")
	private String startSession;
	@Column(name = "end_session")
	private String endSession;
	@Column(name="session_status")
	private boolean status;
	@OneToOne(cascade=CascadeType.ALL)
	private Subject subject;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getStartSession() {
		return startSession;
	}
	public void setStartSession(String startSession) {
		this.startSession = startSession;
	}
	public String getEndSession() {
		return endSession;
	}
	public void setEndSession(String endSession) {
		this.endSession = endSession;
	}

	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
	
	
	
	
}
