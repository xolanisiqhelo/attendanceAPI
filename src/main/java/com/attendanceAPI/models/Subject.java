package com.attendanceAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name="subject")
public class Subject {
	
	
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long id;  
     private String subjctName;
     private String subjectCode;
     
     
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubjctName() {
		return subjctName;
	}
	public void setSubjctName(String subjctName) {
		this.subjctName = subjctName;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
     
}


