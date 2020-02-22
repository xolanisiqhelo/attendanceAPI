	package com.attendanceAPI.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="session")
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String SessionStartNo;
	@OneToOne(cascade = CascadeType.ALL)
	private  Subject subject;
	private Boolean status;
	@JoinTable(name="sessionAttandence", joinColumns=
            @JoinColumn(name="sessionid", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="attandenceid", referencedColumnName="ID"))
	@OneToMany(cascade = CascadeType.ALL)
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
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
	public List<Attandence> setAttandences(Attandence attandence) {
		// TODO Auto-generated method stub
		return null;
	}

}
