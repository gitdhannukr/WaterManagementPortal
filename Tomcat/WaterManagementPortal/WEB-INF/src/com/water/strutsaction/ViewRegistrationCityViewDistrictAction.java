/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.water.strutsaction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * MyEclipse Struts Creation date: 09-20-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 * @struts.action-forward name="failure" path="/Address.jsp"
 * @struts.action-forward name="success" path="/Address.jsp"
 */
public class ViewRegistrationCityViewDistrictAction extends Action {
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
		RegionalFormBean regionalFormBean = (RegionalFormBean) form;// TODO
		// Auto-generated
		// method
		// stub

		String data = request.getParameter("stateid");
		String[] split = data.split(",");
		String[] names = new String[2];
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			names[i] = split[i];
		}

		Vector<District> vDistricts = null;
		HttpSession session = request.getSession();
		try {
			vDistricts = new RegionalInfoDelegate().viewDistrict(Integer
					.parseInt(names[0]));
			session.setAttribute("vDistricts", vDistricts);
			request.setAttribute("statename", names[1]);
			request.setAttribute("stateid", names[0]);
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (Exception e) {
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._VIEW_STATE_FAILURE);
			return mapping.findForward(UtilConstants._SUCCESS);
		}

	}
}