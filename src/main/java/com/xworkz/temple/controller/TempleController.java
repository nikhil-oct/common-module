package com.xworkz.temple.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.temple.dao.PersonalAndVisiDAO;
import com.xworkz.temple.dto.AppPropDTO;
import com.xworkz.temple.dto.PersonalDTO;
import com.xworkz.temple.dto.VisitDTO;
import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;
import com.xworkz.temple.service.AppPropService;
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
			logger.info("*************************Taking the values from the list");
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

}
