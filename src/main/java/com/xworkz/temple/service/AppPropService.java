package com.xworkz.temple.service;

import java.util.List;

import com.xworkz.temple.dto.AppPropDTO;

public interface AppPropService {
	
	public List<AppPropDTO> validateAndFetchAllByType(String type);

}
