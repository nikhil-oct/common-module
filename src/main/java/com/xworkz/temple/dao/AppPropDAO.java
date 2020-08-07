package com.xworkz.temple.dao;

import java.util.List;

import com.xworkz.temple.entity.AppPropEntity;

public interface AppPropDAO {

	public List<AppPropEntity> fetchAllByType(String type);
	
	public Long fetchCountByEmailId(Double emailId);
	
	public Long fetchCountByPhoneNo(Double phoneNo);

}
