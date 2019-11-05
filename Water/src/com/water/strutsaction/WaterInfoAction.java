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
import com.water.delegate.WaterDelegate;
import com.water.exception.ConnectionException;
import com.water.formbean.WaterFormBean;
import com.water.pojo.Education;
import com.water.pojo.WaterInfoPojo;
import com.water.util.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-28-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/WaterInfoAction" name="WaterFormBean" scope="request"
 *                validate="true"
 * @struts.action-forward name="succes" path="/Status.jsp"
 */
public class WaterInfoAction extends Action {
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
		WaterFormBean waterFormBean = (WaterFormBean) form;// TODO
		// Auto-generated
		// method stub
		WaterInfoPojo waterInfoPojo = new WaterInfoPojo(waterFormBean);
		boolean flag = false;
		try {
			flag = new WaterDelegate().addWaterInforamtion(waterInfoPojo);
			request.setAttribute(UtilConstants._STATUS, waterInfoPojo
					.getWater()
					+ " Information added SuddessFully........");
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			return mapping.findForward(UtilConstants._SUCCESS);
		} catch (Exception e) {
			request.setAttribute(UtilConstants._STATUS, waterInfoPojo
					.getWater()
					+ " Information added Operation Fail.");
			return mapping.findForward(UtilConstants._SUCCESS);
		}

	}
}