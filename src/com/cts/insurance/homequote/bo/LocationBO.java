/**
 * This Business Object class is used to for Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.util.List;

import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;

public class LocationBO {

	/**
	 * @param location
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public int saveHomeLocation(final Location location) throws HomequoteBusinessException{

		final LocationDAO locationDAO = new LocationDAO();
		//Fill code here
		
		return 0; //return integer
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Location getHomeLocation(int quoteId) throws HomequoteBusinessException{

		final LocationDAO locationDAO = new LocationDAO();
		//Fill code here
		
		return null; //return Object
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Location> getQuoteIds(String userName) throws HomequoteBusinessException{

		final LocationDAO locationDAO = new LocationDAO();
		//Fill code here
		
		return null; //return    lst of Object
	}
	
}
