package com.xworkz.temple.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.temple.dao.PersonalAndVisiDAO;
import com.xworkz.temple.dto.MailDTO;
import com.xworkz.temple.dto.PersonalDTO;
import com.xworkz.temple.dto.VisitDTO;
import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;

@Service
public class PeronalAndVisitServiceImpl implements PersonalAndVisitService {

	@Autowired
	private PersonalAndVisiDAO dao;

	@Autowired
	private MailService mailService;

	PersonalEntity personalEntity = new PersonalEntity();

	VisitEntity visitEntity = new VisitEntity();

	private static final Logger logger = Logger.getLogger(PeronalAndVisitServiceImpl.class);

	public PeronalAndVisitServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@Override
	public int validateAndCreate(PersonalDTO personalDTO, VisitDTO visitDTO) {
		logger.info("Start : service");
		int valid = 1;
		try {
			if (Objects.nonNull(personalDTO)) {
				String name = personalDTO.getName();
				if (Objects.nonNull(name) && !name.isEmpty()) {
					logger.info("name is valid");
					valid = 0;
				} else {
					System.out.println("name is not Valid");
					valid = 1;
				}
				String mobile = personalDTO.getMobile();
				if (valid == 0 && Objects.nonNull(mobile) && !mobile.isEmpty()) {
					logger.info("mobile is valid");
					valid = 0;
				} else {
					System.out.println("mobile is not Valid");
					valid = 1;
				}
				String email = personalDTO.getEmail();
				if (valid == 0 && Objects.nonNull(email) && !email.isEmpty()) {
					logger.info("email is valid");
					valid = 0;
				} else {
					System.out.println("email is not Valid");
					valid = 1;
				}
				String address = personalDTO.getAddress();
				if (valid == 0 && Objects.nonNull(address) && !address.isEmpty()) {
					logger.info("address is valid");
					valid = 0;
				} else {
					logger.info("address is not Valid");
					valid = 1;
				}

				String age = personalDTO.getAge();
				if (valid == 0 && Objects.nonNull(age) && !age.isEmpty()) {
					logger.info("age is valid");
					valid = 0;
				} else {
					logger.info("age is not Valid");
					valid = 1;
				}

				String state = personalDTO.getAddress();
				if (valid == 0 && Objects.nonNull(state) && !state.isEmpty()) {
					logger.info("state is valid");
					valid = 0;
				} else {
					logger.info("state is not Valid");
					valid = 1;
				}

				long countEmail = dao.fetchCountByEmailId(personalDTO.getEmail());
				long countMobile = dao.fetchCountByMobile(personalDTO.getMobile());
				logger.info("fetchCountByEmailId"+countEmail);
				logger.info("fetchCountByMobile"+countMobile);

				if (countEmail == 0 && countEmail!=1 && countMobile == 0 && countMobile!=1) {

					if (valid == 0) {

						logger.info("Email and mobile Number Validated Succesfully");
						logger.info("Validated the Personal Dto And Visiting DTO");

						String emailBody = new String("Thank You for Temple Registration and Check the Details Below");
						String emailSubjectName = new String("Hi," + "\n"
								+ "Successfully Registered for the Temple Visitation" + "\n" + "Name of the Visiter : "
								+ personalDTO.getName() + "\n" + "EmailId of the Visiter : " + personalDTO.getEmail()
								+ "\n" + "Number of the Visiter : " + visitDTO.getNoOfPersonList() + "\n"
								+ "Phone Number of the Visiter : " + personalDTO.getMobile() + "\n"
								+ "Pooja Type of the Visiter : " + visitDTO.getPoojaTypeList() + "\n"
								+ "Special Entry of the Visiter : " + visitDTO.getSpecialEntryList() + "\n"
								+ "Date of Visiting : " + visitDTO.getDate()

						);

						visitEntity.setPersonalEntity(personalEntity);
						personalEntity.setVisitEntity(visitEntity);

						logger.info("Copying PersonalEntity into Personal DTO");
						BeanUtils.copyProperties(personalDTO, personalEntity);
						logger.info("Copying visitEntity into visitDTO");
						BeanUtils.copyProperties(visitDTO, visitEntity);
						logger.info("Creating method DAO");
						dao.create(personalEntity);

						MailDTO mailDto = new MailDTO(personalDTO.getEmail(), emailSubjectName, emailBody);

						mailService.sendMail(mailDto);
					} else {
						logger.info("Data Not Availabel");
					}
				}
			} else {
				logger.info("Email Id and Mobile Number is already exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;

	}

}
