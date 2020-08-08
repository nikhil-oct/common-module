package com.xworkz.temple.controller;

import java.util.List;

import javax.annotation.PostConstruct;

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
import com.xworkz.temple.service.LoginSERVICE;
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
	public LoginSERVICE loginService;

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
			//TODO DEBUG
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
			
		}
		logger.info("Passing the Value");
		return null;

		//return "register";
		
	}
	
	/**
	*
	*	<c:if test="${dataAvailable}">
	*	<h4>Email Address is : ${personalDTO.email}</h4>
	*	<h4>Phone  is : ${personalDTO.phone}</h4>
	*
	*	</c:if>
	*/
	
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String bySuccess(PersonalDTO personalDTO,VisitDTO visitDTO,Model model) {
		try {
			
			int check=this.personalAndVisitService.validateAndCreate(personalDTO, visitDTO);
			if (check==0) {
			//personalAndVisitService.validateAndCreate(personalDTO,visitDTO);
			logger.info("Values of PrsonalEntity"+personalDTO);						
			model.addAttribute("personalDTO", personalDTO);	
			model.addAttribute("visitDTO", visitDTO);
			model.addAttribute("dataAvailable", true);					
			return "success";
			//return "register";
			}else {
			logger.info("Data is Not Validated Back to Main Page");
			model.addAttribute("dataAvailable", false);	
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
	public String loginPage(String email,String password, Model model) {
		try {
			logger.info("Invoked login page with emailId and password,later redirect to loginsuccess.jsp");
			
			int isUpdated=loginService.validateAndUpdateDetails(email, password);
			if(isUpdated==1) {
				return "requestSuccess";
			}else {
				return "register";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "Registration";
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

}
