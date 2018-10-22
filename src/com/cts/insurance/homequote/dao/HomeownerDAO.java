/**
 * This DAO class is used to for Homeowner Information
 *
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.model.Quote;
import com.cts.insurance.homequote.model.User;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class HomeownerDAO {
	
	private final static Logger LOG = Logger.getLogger(HomeownerDAO.class);

	/**
	 * @param homeowner
	 * @param quoteId 
	 */
	public void saveHomeowner(final Homeowner homeowner, int quoteId) throws HomequoteSystemException
	{
		LOG.info("HomeownerDAO.saveHomeowner - starts");
		Connection conn = null;
		PreparedStatement stmtQuote = null;
		PreparedStatement stmtHome = null;
		ResultSet resultSetQuote = null;
		ResultSet resultSetHome = null;
		Quote quote = null;
		
		try
		{
			// sets up a connection with the SQL database
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			
			stmtQuote = conn.prepareStatement(SqlQueries.GET_QUOTE_ID);
			stmtQuote.setInt(1, quoteId);
			resultSetQuote = stmtQuote.executeQuery();
			
			if (resultSetQuote.next()) {
				quote = new Quote();
				
				// set Quote object variables based on sql query
				quote.setQuoteId((resultSetQuote.getInt(1)));
				quote.setPremium(resultSetQuote.getDouble(2));
				quote.setDwellingCoverage(resultSetQuote.getDouble(3));
				quote.setDetachedStructure(resultSetQuote.getDouble(4));
				quote.setPersonalProperty(resultSetQuote.getDouble(5));
				quote.setAddnlLivgExpense(resultSetQuote.getDouble(6));
				quote.setMedicalExpense(resultSetQuote.getDouble(7));
				quote.setDeductible(resultSetQuote.getDouble(8));
			}
			
			
			stmtHome = conn.prepareStatement(SqlQueries.GET_HOMEOWNER);
			stmtHome.setInt(1, quoteId);
			resultSetHome = stmtHome.executeQuery();
			if (resultSetHome.next()) {
//				homeowner = new Homeowner();
				
				// set Homeowner object variables based on sql query
				homeowner.setQuoteId(resultSetHome.getInt(1));
				homeowner.setFirstName(resultSetHome.getString(2));
				homeowner.setLastName(resultSetHome.getString(3));
				homeowner.setDob(resultSetHome.getString(4));
				homeowner.setIsRetired(resultSetHome.getString(5));
				homeowner.setSsn(resultSetHome.getString(6));
				homeowner.setEmailAddress(resultSetHome.getString(7));
				
			}

			stmtHome.close();
			stmtQuote.close();
		}
		catch (SQLException e)
		{
			throw new HomequoteSystemException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HomequoteSystemException(e.getMessage());
		} 
		finally
		{
			try
			{
				resultSetQuote.close();
				stmtQuote.close();
				resultSetHome.close();
				stmtHome.close();
				conn.close();
			}
			catch (SQLException e)
			{
				LOG.error("Exception while trying to close Connection : " + e.getMessage() );
			}
		}
		LOG.info("HomeownerDAO.saveHomeowner - ends");
		
		
	}
	

	/**
	 * @param homeowner
	 */
	public Homeowner getHomeowner(final int quoteId) throws HomequoteSystemException
	{
		LOG.info("HomeownerDAO.getHomeowner - starts");
		Connection conn = null;
		Homeowner homeowner = null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Fill code here
		return null; //return Object
	}

}
