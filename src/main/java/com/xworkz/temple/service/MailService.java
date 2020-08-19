package com.xworkz.temple.service;

import com.xworkz.temple.dto.MailDTO;

public interface MailService {

	public boolean sendMail(MailDTO mailDto);
	
}
