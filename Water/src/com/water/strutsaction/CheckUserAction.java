/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.water.strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.water.delegate.SecurityUserDelegate;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-20-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 * @struts.action-forward name="failure" path="/UserRegistrationForm.jsp"
 * @struts.action-forward name="success" path="/UserRegistrationForm.jsp"
 */
public class CheckUserAction extends Action {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("loginname");
		try {
			String user = new SecurityUserDelegate().checkUser(username);
			if (user.equals("")) {
				request.setAttribute("status1", UtilConstants._USER_AVAILABLE);
				return mapping.findForward(UtilConstants._SUCCESS);
			} else
				request
						.setAttribute("status1",
								UtilConstants._USER_NO_AVAILABLE);
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("status1", UtilConstants._USER_AVAILABLE);
			return mapping.findForward(UtilConstants._SUCCESS);
		}
	}
}