package com.xworkz.temple.dao;

import org.springframework.stereotype.Component;

import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;

@Component
public interface PersonalAndVisiDAO {

	public void create(PersonalEntity personalEntity);

	public Long fetchCountByMobile(String mobile);

	public Long fetchCountByEmailId(String emailId);

	public VisitEntity fetchVisitByEmail(String email);

}
