package com.xworkz.temple.service;

import com.xworkz.temple.dto.PersonalDTO;
import com.xworkz.temple.dto.VisitDTO;

public interface PersonalAndVisitService {

	public int validateAndCreate(PersonalDTO personalDTO, VisitDTO visitDTO);

	public VisitDTO validateAndFetchByEmailId(String email);


}
