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
 * MyEclipse Struts
 * Creation date: 09-21-2012
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/Status.jsp"
 */
public class DeleteUserAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String ch[] = request.getParameterValues("ch");
		try {
			for (int i = 0; i < ch.length; i++) {
				System.out.println(ch[i]);
				flag = new SecurityUserDelegate().deleteUsers(Integer
						.parseInt(ch[i]));
			}
			if (flag) {
				request.setAttribute("status", UtilConstants._DELETE_DETAILS);
				return mapping.findForward("success");
			} else {
				request.setAttribute("status",
						UtilConstants._DELETE_DETAILS_FAIL);
				return mapping.findForward("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", e.getMessage());
			return mapping.findForward("failure");
		}
	}
}