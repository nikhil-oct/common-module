package com.xworkz.temple.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.temple.dto.MailDTO;

@Service
public class MailServiceImpl implements MailService {
	
	private static final Logger logger=Logger.getLogger(MailServiceImpl.class);

	@Autowired
	private MailSender mailSender;
	
	public MailServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public boolean sendMail(MailDTO mailDto) {
		try {
			logger.info("Inside sendMail mathod");
			SimpleMailMessage simpleMessage=new SimpleMailMessage();
			simpleMessage.setTo(mailDto.getToEmailId());
			simpleMessage.setSubject(mailDto.getSubject());
			simpleMessage.setText(mailDto.getBody());
			System.out.println(mailSender);
			mailSender.send(simpleMessage);
			
			logger.info("SuccessFully Sended the Mail");
			
			return true;
			
		} catch (Exception me) {
			logger.error(me.getMessage(), me);
		}
		return false;
	}

}
