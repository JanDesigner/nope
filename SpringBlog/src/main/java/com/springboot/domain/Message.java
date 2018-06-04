package com.springboot.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@Column(name="sender_email")
	private String senderEmail;
	@Column(name="message")
	private String content;
	@Column(name="date")
	private Date myDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getMyDate() {
		return myDate;
	}
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	
	
	
}
