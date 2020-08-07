package com.xworkz.temple.service;

public interface LoginSERVICE {
	
	public int validateAndUpdateDetails(String emailId,String password);
	
	public int validateEmailIdAndGeneratePassword(String emailId);

}
