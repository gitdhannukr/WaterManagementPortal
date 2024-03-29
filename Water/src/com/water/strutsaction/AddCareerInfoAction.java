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
import com.water.pojo.Education;
import com.water.pojo.TipsSuggestions;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-22-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/AddCareerInfoAction" name="GeneralFormBean"
 *                input="/AddEducationDetails.jsp" scope="request"
 *                validate="true"
 * @struts.action-forward name="success" path="/AddEducationDetails.jsp"
 */
public class AddCareerInfoAction extends Action {
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

		GeneralFormBean generalFormBean = (GeneralFormBean) form; // TODO
																	// Auto-generated
																	// method
																	// stub
		Education education = new Education(generalFormBean);
		boolean flag = false;
		System.out.println(education.getEducationdocumentaion());
		try {
			flag = new GeneralDelegate().addCareerInformation(education);
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._CAREER_SUCCESS);
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (Exception e) {
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._CAREER_FAILURE);
			return mapping.findForward(UtilConstants._SUCCESS);
		}

	}
}