package com.xworkz.temple.service;

import com.xworkz.temple.dto.VisitDTO;

public interface LoginService {

	public int validateAndUpdateDetails(String emailId, String password);

	public int validateEmailIdAndGeneratePassword(String emailId);

	public int validateEmailIdAndSendForgetPassword(String emailId);
	
	public int validateAndSaveBookingDetails(VisitDTO visitDto);

}
