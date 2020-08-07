package com.xworkz.temple.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.temple.entity.PersonalEntity;
import com.xworkz.temple.entity.VisitEntity;



@Repository
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

	private SessionFactory factory;

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public LoginDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	@Override
	public int updatePersonalInfoDetails(String emailId, String password) {
		logger.info("Start: updatePersonalInfoDetails " + emailId);
		Session session = factory.openSession();
		try {
			logger.info("Start: updatePersonalInfoDetails method in LoginDAOImpl " + emailId);
			logger.info("Factory " + factory);

			session.beginTransaction();
			// STEP1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("updatePersonalInfoDetails");
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			// STEP 2: PROCESS
			int rowsUpdated = query.executeUpdate();
			session.getTransaction().commit();
			return rowsUpdated;

		} catch (Exception e) {
			logger.error("Exception in updatePersonalInfoDetails ", e);
		} finally {
			logger.info("Closing session");
			session.close();
		}
		logger.info("End: updatePersonalInfoDetails " + emailId);
		return 0;
	}

	@Override
	public PersonalEntity fetchPersonalDetailsByEmailIdAndPassword(String emailId, String password) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchPersonalDetailsByEmailIdAndPassword " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchPersonalDetailsByEmailIdAndPassword");
			System.out.println("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			PersonalEntity entity = (PersonalEntity) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println(
					"=======> Hibernate Exception in fetchPersonalDetailsByEmailIdAndPassword " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchPersonalDetailsByEmailIdAndPassword " + emailId);
		return null;
	}

	@Override
	public VisitEntity fetchVisitingDetailsByEmailIdAndPassword(String emailId, String password) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchVisitingDetailsByEmailIdAndPassword " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchVisitingDetailsByEmailIdAndPassword");
			System.out.println("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			VisitEntity entity = (VisitEntity) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println(
					"=======> Hibernate Exception in fetchVisitingDetailsByEmailIdAndPassword " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchVisitingDetailsByEmailIdAndPassword " + emailId);
		return null;
	}

	@Override
	public String generatePassword() {
		StringBuilder builder = new StringBuilder();
		int count = 8;
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}