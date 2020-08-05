package com.xworkz.temple.service;

import com.xworkz.temple.dto.PersonalDTO;
import com.xworkz.temple.dto.VisitDTO;
import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;

public interface PersonalAndVisitService {

	public int validateAndCreate(PersonalDTO personalDTO, VisitDTO visitDTO);

}
