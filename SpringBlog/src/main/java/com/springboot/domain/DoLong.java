package com.springboot.domain;

public class DoLong {

	private long senderId;
	
	private long receiverId;
	
	public DoLong() {
		
	}

	public DoLong(long senderId2, long receiverEmail) {
		this.senderId = senderId2;
		this.receiverId = receiverEmail;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	
	
}
