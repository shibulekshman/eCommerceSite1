package com.pets.dog.web.model;

public class Notice {
	
	String noticeContents;

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	@Override
	public String toString() {
		return "Notice [noticeContents=" + noticeContents + "]";
	}

	public Notice(){
		
	}
	
	public Notice(String noticeContents) {
		this.noticeContents = noticeContents;
	}
}
