/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.water.strutsaction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.water.delegate.RegionalInfoDelegate;
import com.water.exception.ConnectionException;
import com.water.formbean.RegionalFormBean;
import com.water.pojo.State;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-17-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/viewRegStateAction" name="regionalFormBean"
 *                scope="request" validate="true"
 */
public class ViewRegStateAction extends Action {
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
		Vector<State> vStates = null;
		try {
			vStates = new RegionalInfoDelegate().viewStates();
			request.setAttribute("vStates", vStates);
			return mapping.findForward("success");
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			return mapping.findForward("Failure");
		} catch (Exception e) {
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._VIEW_STATE_FAILURE);
			return mapping.findForward("Failure");
		}

	}
}