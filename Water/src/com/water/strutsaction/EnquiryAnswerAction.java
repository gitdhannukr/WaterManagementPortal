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
import com.water.pojo.Enquiry;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-22-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/EnquiryAnswerAction" name="GeneralFormBean"
 *                input="/EnquiryAnswer.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/Status.jsp"
 */
public class EnquiryAnswerAction extends Action {
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
		Enquiry enquiry = new Enquiry(generalFormBean);
		boolean flag = false;
		try {
			flag = new GeneralDelegate().enquryAnswer(enquiry);
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._ENQUIRY_UPDATED_SUCCESS);
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (Exception e) {
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._ENQUIRY_FAILURE);
			return mapping.findForward(UtilConstants._SUCCESS);
		}

	}
}