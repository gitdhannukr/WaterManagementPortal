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

import com.water.delegate.GeneralDelegate;
import com.water.exception.ConnectionException;
import com.water.formbean.GeneralFormBean;
import com.water.pojo.Complaints;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-22-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/PostComplaintAction" name="GeneralFormBean"
 *                input="/CityComplaint.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/CityComplaint.jsp"
 */
public class PostComplaintAction extends Action {
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
		GeneralFormBean generalFormBean = (GeneralFormBean) form;// TODO
		// Auto-generated
		// method
		// stub
		Complaints complaints = new Complaints(generalFormBean);
		boolean flag = false;
		try {
			flag = new GeneralDelegate().addComplaint(complaints);
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._COMPLAINT_SUCCESS);
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (Exception e) {
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._COMPLAINT_FAILURE);
			return mapping.findForward(UtilConstants._SUCCESS);
		}

	}
}