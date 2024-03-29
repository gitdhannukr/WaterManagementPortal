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
import com.water.pojo.District;
import com.water.pojo.State;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-17-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/viewSDistrictAction" name="regionalFormBean"
 *                scope="request" validate="true"
 * @struts.action-forward name="failure" path="/ViewDistricts.jsp"
 * @struts.action-forward name="success" path="/ViewDistricts.jsp"
 */
public class ViewSDistrictAction extends Action {
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
		RegionalFormBean regionalFormBean = (RegionalFormBean) form;// TODO
		// Auto-generated
		// method
		// stub
		
		Vector<District> vDistricts = null;
		try {
			vDistricts = new RegionalInfoDelegate()
					.viewDistrict(regionalFormBean.getStateid());
			request.setAttribute("vDistricts", vDistricts);
			request.setAttribute("statename", regionalFormBean.getStatename());
			return mapping.findForward(UtilConstants._SUCCESS);
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