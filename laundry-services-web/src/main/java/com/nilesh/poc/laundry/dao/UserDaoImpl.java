
package com.nilesh.poc.laundry.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nilesh.poc.laundry.exception.LaundryException;
import com.nilesh.poc.laundry.pojos.User;

@Repository
@Transactional // MANDATORY
public class UserDaoImpl implements IUserDao {
	private final static Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

	// dependency
	@Autowired // auto wiring by type
	private SessionFactory sf;

	public User auntheticateUser(String email1, String pwd) throws LaundryException {
		LOG.info("in auth user ");
		String jpql="select u from User u where u.user_email = :em and u.user_Password=:pass";
		try {
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em",email1).setParameter("pass",pwd)
				.getSingleResult();
		}catch (Exception exe) {
			LOG.error("Exception occurred while login to the system  : "+exe.getMessage());
			throw new LaundryException("Invalid login,Try later !!");
		}

	}

	public String register(User u) throws LaundryException {
		System.out.println("in dao");
		try {
		sf.getCurrentSession().persist(u);
		}catch (Exception exe) {
			LOG.error("Exception occurred while registering to the system due to : "+exe.getMessage());
			throw new LaundryException("Issue occurred while registering to the system,Try later !!");
		}
		return "done";
	
	}
     
	
}
