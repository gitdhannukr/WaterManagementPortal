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
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-18-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 * @struts.action-forward name="failure" path="/AddCity.jsp"
 * @struts.action-forward name="success" path="/AddCity.jsp"
 */
public class CityDistrictAction extends Action {
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
		RegionalFormBean regionalFormBean = (RegionalFormBean) form;
		Vector<District> vDistricts = null;
		System.out.println("state name " + regionalFormBean.getStatename());
		try {
			vDistricts = new RegionalInfoDelegate()
					.viewDistrict(regionalFormBean.getStateid());
			request.setAttribute("vDistricts", vDistricts);
			request.setAttribute("statename", regionalFormBean.getStatename());
			request.setAttribute("stateid", regionalFormBean.getStateid());
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