package com.xworkz.temple.service;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.temple.dao.LoginDAO;
import com.xworkz.temple.dao.PersonalAndVisiDAO;
import com.xworkz.temple.dto.MailDTO;
import com.xworkz.temple.dto.PersonalDTO;
import com.xworkz.temple.dto.VisitDTO;
import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;



@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger=Logger.getLogger(LoginServiceImpl.class);
	
	@Autowired
	public LoginDAO loginDao;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private PersonalAndVisiDAO personalAndVisiDAO;

	StringBuilder str = new StringBuilder("Hello!! \n");
	
	PersonalEntity personalEntity=new PersonalEntity();
	VisitEntity visitingEntity=new VisitEntity();
	 PersonalDTO personalDto=new PersonalDTO();

	public LoginServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@Override
	public int validateAndUpdateDetails(String emailId,String password) {
		logger.info("Create: validateAndUpdateDetails " + emailId);
		try {
			if (Objects.nonNull(emailId) && emailId!=null && Objects.nonNull(password) && password!=null) {
				logger.info("Email and password are valid");
				
				logger.info("fetchPersonalDetailsByEmailIdAndPassword");
				personalEntity=loginDao.fetchPersonalDetailsByEmailIdAndPassword(emailId, password);
				logger.info("fetchVisitingDetailsByEmailId");
				visitingEntity=loginDao.fetchVisitingDetailsByEmailIdAndPassword(emailId, password);
				
				logger.info("getting email and password from database and comparing with sent email and password");
				String fetchedEmail=personalEntity.getEmail();
				String fetchedPassword=personalEntity.getPassword();
				
				if (emailId.equalsIgnoreCase(fetchedEmail) && password.equalsIgnoreCase(fetchedPassword)) {
					logger.info("EmailId and Password matched successfully");
					
					logger.info("Sending Email for Login successfully");
					MailDTO mailDTO = new MailDTO( emailId, str
							.append("Temple Registration logged in for registered email-Id given below").append("\n\n\n")
							.append("Email-Id is: ").append(emailId).append("\n").append("\n\n")
							.append("Regards").append("\n").append("Nikhil..").toString(), "Temple Registration ");

					mailService.sendMail(mailDTO);
					logger.info("Login Mail Sent Successfully");
				}
				return 1;
			} else {
				logger.error("Email or phone does not match");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateAndUpdateDetails " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("End: validateAndUpdateDetails " + emailId);
		return 0;
	}

	@Override
	public int validateEmailIdAndGeneratePassword(String emailId) {
		logger.info("Start: validateEmailIdAndGeneratePassword " + emailId);
		try {
			if(Objects.nonNull(emailId) && emailId!=null) {
				logger.info("Email is valid");
				Long emailCount=personalAndVisiDAO.fetchCountByEmailId(emailId);
				if(emailCount==1) {
					logger.info("Data is valid and can generate password");
					String generatedpassword=loginDao.generatePassword();
					System.out.println("*******************"+generatedpassword);
					logger.info("password generated of 8 digit alphanumeric");
					
					logger.info("Updating the generated password into database by calling validateAndUpdateDetails");
					
					logger.info("Updating PersonalInfo Details " + personalEntity);
					logger.info("Updating visitingInfo Details " + visitingEntity);
					int isUpdated=loginDao.updatePersonalInfoDetails(emailId,generatedpassword);
					if(isUpdated==1) {
						logger.info("Password updated for given email-id");
						
						logger.info("Sending Email and password for registered mail");
						MailDTO mailDTO = new MailDTO( emailId, str
								.append("Temple Registration password is sent below,").append("\n\n\n")
								.append("Email-Id is: ").append(emailId).append("\n")
								.append("Password is: ").append(generatedpassword).append("\n\n")
								.append("Regards").append("\n").append("Nikhil..").toString(), "Temple Registration ");

						mailService.sendMail(mailDTO);
						logger.info("Login Mail Sent Successfully");
						return 1;
					}else {
						logger.info("Password not updated for given email-id");
						return 0;
					}
				}else {
					logger.info("Email does not exists, re-check email-Id");
					return 0;
				}
			}else {
				logger.info("Email-Id provided in invalid");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateEmailIdAndGeneratePassword ", e);
		}
		logger.info("End: validateEmailIdAndGeneratePassword " + emailId);
		return 0;
	}

	@Override
	public int validateEmailIdAndSendForgetPassword(String emailId) {
		logger.info("Start: validateEmailIdAndSendForgetPassword " + emailId);
		try {
			if (Objects.nonNull(emailId) && emailId != null) {
				logger.info("Data is valid and can fetch password");
				String fetchedPassword = loginDao.fetchPasswordByEmailId(emailId);
				if (Objects.nonNull(fetchedPassword)) {

					logger.info("Password updated for given email-id");
					
					logger.info("Sending Email and password for registered mail");
					MailDTO mailDTO = new MailDTO( emailId, str
							.append("Temple Registration password is sent below,").append("\n\n\n")
							.append("Email-Id is: ").append(emailId).append("\n")
							.append("Password is: ").append(fetchedPassword).append("\n\n")
							.append("Regards").append("\n").append("Nikhil..").toString(), "Temple Registration ");

					mailService.sendMail(mailDTO);
					logger.info("Forgot password Mail Sent Successfully");
					return 1;
				} else {
					logger.info("Fetched password is null");
					return 0;
				}
			} else {
				logger.info("Email-Id provided is invalid");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateEmailIdAndSendForgetPassword ", e);
		}
		logger.info("End: validateEmailIdAndSendForgetPassword " + emailId);
		return 0;
	}
	
	@Override
	public int validateAndSaveBookingDetails(VisitDTO visitDto) {
		logger.info("Create: validateAndSaveBookingDetails " + visitDto);
		try {
				String emailId=(String) httpSession.getAttribute("emailId");
				logger.info("Email id fetched from http session "+emailId);

				if (emailId != null) {
					
					VisitEntity visitEntity=personalAndVisiDAO.fetchVisitByEmail(emailId);
					
					BeanUtils.copyProperties(visitDto, visitEntity);

					logger.info("Saving visitingInfo Details " + visitEntity);
					personalAndVisiDAO.createVisit(visitEntity);
					return 1;
				}else {
					logger.info("Email id  is null");
					return 0;
				}
		} catch (Exception e) {
			logger.error("Exception in validateAndSaveBookingDetails " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("End: validateAndSaveBookingDetails " + visitDto);
		return 0;
	}

	
}
