package com.xworkz.temple.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.temple.entity.AppPropEntity;

@Component
public class AppPropDAOImpl implements AppPropDAO {

	private SessionFactory factory;
	private static final Logger logger = Logger.getLogger(AppPropDAOImpl.class);

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public AppPropDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	public List<AppPropEntity> fetchAllByType(String type) {
		System.out.println("Start : Daoimpl");
		Session session = this.factory.openSession();
		try {
			logger.info("START : fetchAllByType " + type);
			Query query = session.getNamedQuery("fetchAllByType");
			logger.info("Fetching query and values from Entity");
			logger.info("QUERY---->" + query);
			query.setParameter("type", type);
			List<AppPropEntity> fetchedList = query.list();
			logger.info("SE list from daoimpl is :" + fetchedList);
			logger.info("End : DaoImpl");
			return fetchedList;
		} catch (HibernateException hibernate) {
			logger.error("Hibernate Exception in fetchAllByType " + hibernate.getMessage());
		} finally {
			session.close();
		}
		logger.info("END : fetchAllByType " + type);

		return null;
	}

}
