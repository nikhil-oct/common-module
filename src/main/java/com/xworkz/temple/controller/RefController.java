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
import com.xworkz.temple.dto.VisitDTO;
import com.xworkz.temple.service.AppPropService;
import com.xworkz.temple.service.LoginService;

@Component
@RequestMapping("/")
public class RefController {
	
	private Logger logger = Logger.getLogger(RefController.class);
	
	private List<AppPropDTO> entryList;
	private List<AppPropDTO> nopersonList;
	private List<AppPropDTO> prasadaList;
	private List<AppPropDTO> idList;
	private List<AppPropDTO> poojaTypeList;

	@Autowired
	public AppPropService appPropertyService;
	
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
	
	@RequestMapping(value = "/booksearch.do")
	public String doNavigateForBookingPage(Model model) {
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
		return "book";
	}

}
