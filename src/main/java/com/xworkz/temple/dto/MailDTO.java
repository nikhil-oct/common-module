package com.xworkz.temple.dto;

import org.apache.log4j.Logger;

public class MailDTO {

	private static final Logger logger = Logger.getLogger(MailDTO.class);

	private String toEmailId;
	private String body;
	private String subject;

	public MailDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	public MailDTO(String toEmailId, String body, String subject) {
		super();
		this.toEmailId = toEmailId;
		this.body = body;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MailDTO [toEmailId=" + toEmailId + ", body=" + body + ", subject=" + subject + "]";
	}

	public String getToEmailId() {
		return toEmailId;
	}

	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
