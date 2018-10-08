package com.javaweb.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "Inquiry")
public class Inquiry implements java.io.Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String inquiry;
	private String recomendations;
    private String timeStamp;
	//private LocalDateTime timeStamp;

	public Inquiry() {
	}

	public Inquiry(String inquiry, String recomendations, String timeStamp) {
		this.inquiry = inquiry;
		this.recomendations = recomendations;
		this.timeStamp = timeStamp;
	}

	public Inquiry(String firstName, String lastName, String email, String inquiry, String recomendations, String timeStamp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.inquiry = inquiry;
		this.recomendations = recomendations;
		this.timeStamp = timeStamp;
	}
	
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "first_name", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "inquiry", nullable = false, length = 150)
	public String getInquiry() {
		return this.inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	@Column(name = "recomendations", nullable = false)
	public String getRecomendations() {
		return this.recomendations;
	}

	public void setRecomendations(String recomendations) {
		this.recomendations = recomendations;
	}
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_stamp", nullable = false, length = 60)
	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
