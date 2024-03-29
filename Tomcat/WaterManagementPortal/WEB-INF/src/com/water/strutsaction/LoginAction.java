/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.water.strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.water.delegate.SecurityUserDelegate;
import com.water.exception.ConnectionException;
import com.water.exception.LoginException;
import com.water.formbean.ProfileFormBean;
import com.water.pojo.LoginDetails;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-20-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/LoginAction" name="profileFormBean" scope="request"
 *                validate="true"
 * @struts.action-forward name="success" path="/HomePage.jsp"
 */
public class LoginAction extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ProfileFormBean profileFormBean = (ProfileFormBean) form;// TODO
		// Auto-generated
		// method
		// stub
		LoginDetails loginDetails = new LoginDetails(profileFormBean);
		LoginDetails lDetails = null;
		HttpSession session = request.getSession();
		try {
			lDetails = new SecurityUserDelegate().loginCheck(loginDetails);
			request
					.setAttribute("status", "Welcome "
							+ lDetails.getLoginname());
			session.setAttribute(UtilConstants._LOGINID, lDetails.getLoginid());
			session.setAttribute(UtilConstants._LOGIN_NAME, lDetails
					.getLoginname());
			session
					.setAttribute(UtilConstants._USERID, lDetails
							.getUseridref());
			session.setAttribute(UtilConstants._CITYID, lDetails
					.getSecuritycode());
			session.setAttribute(UtilConstants._ROLE, lDetails.getLogintype());
			System.out.println( lDetails.getLogintype());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (LoginException e) {
			request.setAttribute("status", e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		}
	}
}