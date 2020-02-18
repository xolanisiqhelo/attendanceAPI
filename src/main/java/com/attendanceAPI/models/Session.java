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
@Table(name="session")
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
//	private Boolean status;
	@OneToOne(cascade = CascadeType.ALL)
	private  Subject subject;
	@JoinTable(name="sessionAttandence", joinColumns=
            @JoinColumn(name="sessionid", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="attandenceid", referencedColumnName="ID"))
	@OneToMany(cascade = CascadeType.ALL)
	private List<Attandence> attandences;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
//	public Boolean getStatus() {
//		return status;
//	}
//	public void setStatus(Boolean status) {
//		this.status = status;
//	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Attandence> getAttandences() {
		return attandences;
	}
	public void setAttandences(List<Attandence> attandences) {
		this.attandences = attandences;
	}

	@Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
