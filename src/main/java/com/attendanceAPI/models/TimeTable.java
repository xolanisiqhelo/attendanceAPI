package com.attendanceAPI.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;


@Entity
@Table(name="timetable")
public class TimeTable  {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name="timeTableSlot", joinColumns=
            @JoinColumn(name="timetableid", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="slotid", referencedColumnName="ID"))
	private List<Slot> slots;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Lecture lecture; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}


	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
	
	
	
		
	
	
}
