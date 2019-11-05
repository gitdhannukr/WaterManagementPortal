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
import com.water.formbean.ProfileFormBean;
import com.water.pojo.UserDetails;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-21-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/RecoverPasswordAction" name="profileFormBean"
 *                scope="request" validate="true"
 */
public class RecoverPasswordAction extends Action {
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
		boolean flag = false;
		UserDetails userDetails = new UserDetails(profileFormBean);
		try {
			flag = new SecurityUserDelegate().passwordRecovery(userDetails);
			if (flag) {
				request.setAttribute("loginid", profileFormBean.getLoginname());
				return mapping.findForward(UtilConstants._SUCCESS);
			} else {
				request.setAttribute("status",
						UtilConstants._RECOVER_PASSWORD_FAILED);
				return mapping.findForward(UtilConstants._FAILURE);
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			return mapping.findForward(UtilConstants._FAILURE);

		}
	}
}