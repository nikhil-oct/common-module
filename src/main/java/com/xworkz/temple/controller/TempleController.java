package com.xworkz.temple.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.temple.dto.AppPropDTO;
import com.xworkz.temple.dto.PersonalDTO;
import com.xworkz.temple.dto.VisitDTO;
import com.xworkz.temple.service.AppPropService;
import com.xworkz.temple.service.LoginService;
import com.xworkz.temple.service.PersonalAndVisitService;

@Component
@RequestMapping("/")
public class TempleController {

	private Logger logger = Logger.getLogger(TempleController.class);

	private List<AppPropDTO> entryList;
	private List<AppPropDTO> nopersonList;
	private List<AppPropDTO> prasadaList;
	private List<AppPropDTO> idList;
	private List<AppPropDTO> poojaTypeList;

	@Autowired
	public AppPropService appPropertyService;
	
	@Autowired
	public LoginService loginService;

	@Autowired
	public PersonalAndVisitService personalAndVisitService;

	public TempleController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
		// System.out.println("Created "+this.getClass().getSimpleName());
	}

	@PostConstruct
	public void init() {
		logger.info("Invoked init() method ");
		logger.info("Assign all the Type drop down");
		entryList = appPropertyService.validateAndFetchAllByType("SE");
		logger.info("******************************"+entryList);
		nopersonList = appPropertyService.validateAndFetchAllByType("NOP");
		prasadaList = appPropertyService.validateAndFetchAllByType("PRASAD");
		idList = appPropertyService.validateAndFetchAllByType("ID");
		poojaTypeList = appPropertyService.validateAndFetchAllByType("POOJA");
		logger.info("End of init() method");
	}

	@RequestMapping(value = "/sending.do", method = RequestMethod.GET)
	public String byLanding(Model model) {
		try {
			logger.info("Invoked landing Method with success.jsp");
			logger.info("Taking the values from the list");
			model.addAttribute("specialEntryList", entryList);
			logger.info("Special Entry Values " + entryList);
			model.addAttribute("noOfPersonList", nopersonList);
			logger.info("nO OF PEERSON values " + nopersonList);
			model.addAttribute("prasadaList", prasadaList);
			logger.info("Prasada Values " + prasadaList);
			model.addAttribute("idList", idList);
			logger.info("ID Values " + idList);
			model.addAttribute("poojaTypeList", poojaTypeList);
			logger.info("Pooja Values " + poojaTypeList);
			logger.info("Invoked landing page");

			return "register";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Passing the Value");
		return null;

		//return "register";
		
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String bySuccess(PersonalDTO personalDTO,VisitDTO visitDTO,Model model) {
		try {
			
			int check=this.personalAndVisitService.validateAndCreate(personalDTO, visitDTO);
			if (check==0) {
			//personalAndVisitService.validateAndCreate(personalDTO,visitDTO);
			logger.info("Values of PrsonalEntity"+personalDTO);
			
			model.addAttribute("name", "Name of the Visiter : " + personalDTO.getName());
			logger.info("Name of the Visiter : " + personalDTO.getName());
			model.addAttribute("mobile", "Mobile of the Visiter : " + personalDTO.getMobile());
			logger.info("Mobile of the Visiter : " + personalDTO.getMobile());
			model.addAttribute("state", "State of the Visiter : " + personalDTO.getState());
			logger.info("State of the Visiter : " + personalDTO.getState());
			model.addAttribute("address", "Address of the Visiter : " + personalDTO.getAddress());
			logger.info("Address of the Visiter : " + personalDTO.getAddress());
			model.addAttribute("age", "Age of the Visiter : " + personalDTO.getAge());
			logger.info("Age of the Visiter : " + personalDTO.getAge());
			model.addAttribute("email", "Email of the Visiter : " + personalDTO.getEmail());
			logger.info("Email of the Visiter : " + personalDTO.getEmail());
			
			logger.info("Values of VisitEntity"+visitDTO);
			
			model.addAttribute("se", "Visiter Entry : "+visitDTO.getSpecialEntryList());
			logger.info( "Visiter Entry : "+visitDTO.getSpecialEntryList());
			model.addAttribute("nop", "No Of Person in the Entry : "+visitDTO.getNoOfPersonList());
			logger.info("No Of Person in the Entry : "+visitDTO.getNoOfPersonList());
			model.addAttribute("date", "Date of Visiting : "+visitDTO.getDate());
			logger.info("Date of Visiting : "+visitDTO.getDate());
			model.addAttribute("idList", "Id of Entry : "+visitDTO.getIdList());
			logger.info("Id of Entry : "+visitDTO.getIdList());
			model.addAttribute("idNo", "Id No of the Entry : "+visitDTO.getIdNo());
			logger.info("Id No of the Entry : "+visitDTO.getIdNo());
			model.addAttribute("prasasa", "Prasada Type : "+visitDTO.getPrasadaList());
			logger.info("Prasada Type : "+visitDTO.getPrasadaList());
			model.addAttribute("poojatype", "Pooja Type Entry : "+visitDTO.getPoojaTypeList());
			logger.info("Pooja Type Entry : "+visitDTO.getPoojaTypeList());
			
			return "success";
			//return "register";
			}else {
			logger.info("Data is Not Validated Back to Main Page");
			return "register";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Passing the Value");
		return null;

		//return "register";
	}
	
	@RequestMapping(value="/resending.do" ,method=RequestMethod.POST)
	public String byResend(String email,Model model,PersonalDTO personaldto) {
		try {
			logger.info("inside  resend mail");

			if(email.equals(personaldto.getEmail())) {
			VisitDTO visitDTO = personalAndVisitService.validateAndFetchByEmailId(email);
			logger.info("***********"+visitDTO);

			return "requestSuccess";
			}else {
				return "login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginPage(String email,String password, Model model,HttpSession httpSession) {
		try {
			logger.info("Invoked login page with emailId and password,later redirect to loginsuccess.jsp");
			
			httpSession.setAttribute("emailId", email);
			int isUpdated=loginService.validateAndUpdateDetails(email, password);
			if(isUpdated==1) {
				model.addAttribute("emailId", email);
				return "bookSearch";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "register";
	}

	@RequestMapping(value = "/newlogin.do", method = RequestMethod.POST)
	public String generatingPasswordPage(String email, Model model) {
		try {
			logger.info("Invoked login page with emailId,later redirect to login.jsp");
			
			loginService.validateEmailIdAndGeneratePassword(email);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "login";
	}
	
	@RequestMapping(value = "/forget.do", method = RequestMethod.POST)
	public String generateForgetPassword(String email, Model model) {
		try {
			logger.info("Invoked forgot password page with emailId,later redirect to login.jsp");
			int count=loginService.validateEmailIdAndSendForgetPassword(email);
			if(count==1) {
				return "login";
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "error";
	}
	
	@RequestMapping(value = "/book.do", method = { RequestMethod.POST })
	public String bookPage(VisitDTO visitDto, Model model) {
		try {
			logger.info("Invoked Booking page with list values,later redirect to success.jsp");

			logger.info("Booking temple visting details");
			int isValid=loginService.validateAndSaveBookingDetails(visitDto);
		
			if (isValid ==1) {
				
				model.addAttribute("success", "Booking done successfully..");

				logger.info("Directing to LoginSuccess.jsp");
				return "success";
			} else {
				System.out.println("Data not valid");
				model.addAttribute("Error", "Please check which field is not valid and enter valid data");
				return "register";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "error";
	}


}
