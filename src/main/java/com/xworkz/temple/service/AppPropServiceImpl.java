package com.xworkz.temple.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.temple.dao.AppPropDAO;
import com.xworkz.temple.dto.AppPropDTO;
import com.xworkz.temple.entity.AppPropEntity;

@Service
public class AppPropServiceImpl implements AppPropService {

	@Autowired
	private AppPropDAO dao;

	private static final Logger logger = Logger.getLogger(AppPropServiceImpl.class);

	public AppPropServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public List<AppPropDTO> validateAndFetchAllByType(String type) {
		logger.info("Start: validateAndFetchAllByType ");
		try {

			List<AppPropEntity> fetchedEntity = dao.fetchAllByType(type);

			if (Objects.nonNull(fetchedEntity)) {
				logger.info("List is found and its size is : " + fetchedEntity.size());
				List<AppPropDTO> list = new ArrayList<AppPropDTO>();
				for (AppPropEntity fetch : fetchedEntity) {
					AppPropDTO dto = new AppPropDTO();
					logger.info("Copying data from dto to entity");
					BeanUtils.copyProperties(fetch, dto);
					list.add(dto);
					logger.info("Adding all the dto's to list" + list);

				}
				return list;
			} else {
				logger.info("Any List found in the Entity");
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception in validateAndFetchAllByType " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("End: validateAndFetchAllByType ");
		return null;
	}

}
