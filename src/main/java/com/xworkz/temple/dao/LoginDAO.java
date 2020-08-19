package com.xworkz.temple.dao;

import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;

public interface LoginDAO {
	
	public int updatePersonalInfoDetails(String emailId,String password);
	
	public PersonalEntity fetchPersonalDetailsByEmailIdAndPassword(String emailId,String password);
	
	public VisitEntity fetchVisitingDetailsByEmailIdAndPassword(String emailId,String password);
	
	public String generatePassword();
	
	public String fetchPasswordByEmailId(String emailId) ;

}
