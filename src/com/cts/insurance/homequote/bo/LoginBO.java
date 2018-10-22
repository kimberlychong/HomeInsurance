/**
 * This Action class is used to to capture the Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.LoginDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.User;

public class LoginBO {

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	
	// called from LoginServlet.java 
	// get method - getUser()
	// passes String 
	public User getUser(final String userName) throws HomequoteBusinessException{

		final LoginDAO loginDAO = new LoginDAO();
		User user = null;
		
		// WIP
		try {
			
		}
		catch (Exception e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
		finally {
			
		}
		
		return user;
	}
	
	/**
	 * registerUser
	 * @param user
	 * @throws HomequoteBusinessException
	 */
	
	// called from LoginServlet - loginNewUser()
	// user object properties (username & password) set in LoginServlet
	public void registerUser(final User user) throws HomequoteBusinessException{

		final LoginDAO loginDAO = new LoginDAO();

		try {
			// save user in SQL database
			loginDAO.saveUser(user);
		} catch (HomequoteSystemException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}







