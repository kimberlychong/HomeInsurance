/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.cts.insurance.homequote.dao.PolicyDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Policy;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class PolicyBO {
	/**
	 * @param quoteId
	 * @param policyEffectiveDate
	 * @return
	 */
	public Policy savePolicy(final int quoteId, final String policyEffDate, final int term) throws HomequoteBusinessException{
		final PolicyDAO poilcyDAO = new PolicyDAO();
		try
		{	
			final Policy policy = new Policy();		
			policy.setQuoteId(quoteId);
			policy.setPolicyEffDate(policyEffDate);
			policy.setPolicyEndDate(getDateAfterOneYear(policyEffDate));
			policy.setPolicyTerm(term);
			policy.setPolicyKey(quoteId + "_" + policy.getPolicyTerm());
			policy.setPolicyStatus(HomeInsuranceConstants.STATUS_ACTIVE);
			poilcyDAO.savePolicy(policy);
			return policy;
		}
		catch(ParseException e)
		{
			throw new HomequoteBusinessException(e.getMessage());
		}
		catch(HomequoteSystemException e)
		{
			throw new HomequoteBusinessException(e.getMessage());
		}
	}

	/**
	 * @param userName
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Policy> getPolicies(final String userName) throws HomequoteBusinessException {

		final PolicyDAO poilcyDAO = new PolicyDAO();
		//Fill code here
		
		return null; //return list of Object
	}
	
	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Policy cancelPolicy(final String policyKey) throws HomequoteBusinessException {

		final PolicyDAO poilcyDAO = new PolicyDAO();
		//Fill code here
		
		return null; //return Object
	}
	
	/**
	 * @param policyKey
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Policy renewPolicy(final String policyKey) throws HomequoteBusinessException {

		final PolicyDAO poilcyDAO = new PolicyDAO();
		//Fill code here
		return null; //return Object
	}
	/**
	 * @param policyEffectiveDate
	 * @throws ParseException
	 */
	private String getDateAfterOneYear(final String policyEffDate) throws ParseException
	{
		//Fill code here
		return null; //return String
	}
}
