package com.xworkz.temple.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;

@Controller
public class PersonalAndVisiDAOImpl implements PersonalAndVisiDAO {
	
	private static final Logger logger = Logger.getLogger(PersonalAndVisiDAOImpl.class);

	private SessionFactory factory;

	public PersonalAndVisiDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void create(PersonalEntity personalEntity) {
		logger.info("Invoked Create Method");
		logger.info("Using Personal and Visit DAOImpl Calling Create method");

		Session session = null;
		logger.info(personalEntity);
		session = factory.openSession();
		try {
			logger.info("Begin the Transaction");
			session.beginTransaction();
			logger.info("Save the Entity");
			session.save(personalEntity);
			//session.save(visitEntity);
			logger.info("Commit the Transcation");
			session.getTransaction().commit();
			logger.info("Inserted successfully");
			logger.info("End of the Create Method");

		} catch (Exception e) {
			logger.error("Create is Unsuccesssfully And RollBack");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			logger.info("Using Finally Session is Closed");
		}

	}

	@Override
	public Long fetchCountByMobile(String mobile) {
		logger.info("Invoked fetchCountByMobile method ");

		Session session = this.factory.openSession();

		try {

			logger.info("Setting the query by session and named query in the entity for the Mobile ");
			Query query = session.getNamedQuery("fetchCountByMobile");
			logger.info("Setting the Parameter name is in the Entity");
			query.setParameter("sanMobile", mobile);
			logger.info("Passing the query Result to UniqueResult Method");
			Object result = query.uniqueResult();
			logger.info("Passing the UniqueResult using Return type");
			Long entity = (Long) result;
			logger.info("Number of Mobile No : "+entity);

			return entity;

		} catch (HibernateException e) {
			logger.error("$$$$$$$$ Exception in fetchCountByMobile" + e.getMessage() + e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long fetchCountByEmailId(String emailId) {
		logger.info("Invoked fetchCountByEmailId method ");

		Session session = this.factory.openSession();

		try {

			logger.info("Setting the query by session and named query in the entity for the EmailId ");
			Query query = session.getNamedQuery("fetchCountByEmailId");
			logger.info("Setting the Parameter name is in the Entity");
			query.setParameter("sanEmailId", emailId);
			logger.info("Passing the query Result to UniqueResult Method");
			Object result = query.uniqueResult();
			logger.info("Passing the UniqueResult using Return type");
			Long entity = (Long) result;
			logger.info("Number of Email : "+entity);
			return entity;

		} catch (HibernateException e) {
			logger.error("$$$$$$$$ Exception in fetchCountByEmailId" + e.getMessage() + e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public VisitEntity fetchVisitByEmail(String email) {
		logger.info("Invoked fetchVisitByEmail method ");

		Session session = this.factory.openSession();

		try {

			logger.info("Setting the query by session and named query in the entity for the EmailId ");
			Query query = session.getNamedQuery("fetchVisitByEmail");
			logger.info("Setting the Parameter name is in the Entity");
			query.setParameter("visEmail", email);
			logger.info("Passing the query Result to UniqueResult Method");
			Object result = query.uniqueResult();
			logger.info("Passing the UniqueResult using Return type");
			VisitEntity entity = (VisitEntity) result;
			logger.info("Details of Visit Entity"+entity);
			return entity;

		} catch (HibernateException e) {
			logger.error("$$$$$$$$ Exception in fetchVisitByEmail" + e.getMessage() + e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
//
}
