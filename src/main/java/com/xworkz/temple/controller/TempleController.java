package com.xworkz.temple.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.temple.dto.AppPropDTO;
import com.xworkz.temple.service.AppPropService;

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

	public TempleController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
		// System.out.println("Created "+this.getClass().getSimpleName());
	}

	@PostConstruct
	public void init() {
		logger.info("Invoked init() method ");
		logger.info("Assign all the Type drop down");
		entryList = appPropertyService.validateAndFetchAllByType("SE");
		nopersonList = appPropertyService.validateAndFetchAllByType("NOP");
		prasadaList = appPropertyService.validateAndFetchAllByType("PRASAD");
		idList = appPropertyService.validateAndFetchAllByType("ID");
		poojaTypeList = appPropertyService.validateAndFetchAllByType("POOJA");
		logger.info("End of init() method");
	}

	@RequestMapping(value = "/sending.do")
	public String landingPage(Model model) {
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
			return "success";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Passing the Value");

		return null;
	}

}
