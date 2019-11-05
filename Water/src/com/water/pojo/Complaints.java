package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.GeneralFormBean;
import com.water.formbean.RegionalFormBean;

/**
 * Complaints entity. @author MyEclipse Persistence Tools
 */

public class Complaints implements java.io.Serializable {

	// Fields

	private int complaintid;
	private City City;
	private String complaintarea;
	private String complaintername;
	
	private String complaint;
	private String complaintsolution;
	private String complaintstatusstatus;
	private int cityidref;

// Constructors

	/** default constructor */
	public Complaints() {
	}

	public Complaints(GeneralFormBean generalFormBean) {
		Map map;
		try {
			map = BeanUtils.describe(generalFormBean);
			BeanUtils.populate(this, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	/** full constructor */
	public Complaints(City City, String complaintarea,
			String complaintername, String complaint,
			String complaintsolution, String complaintstatusstatus) {
		this.City = City;
		this.complaintarea = complaintarea;
		this.complaintername = complaintername;
		this.complaint = complaint;
		this.complaintsolution = complaintsolution;
		this.complaintstatusstatus = complaintstatusstatus;
	}

	// Property accessors

	public City getCITY() {
		return this.City;
	}

	public int getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}

	public void setCITY(City City) {
		this.City = City;
	}

	public String getComplaintarea() {
		return this.complaintarea;
	}

	public void setComplaintarea(String complaintarea) {
		this.complaintarea = complaintarea;
	}


	public String getComplaint() {
		return this.complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getComplaintsolution() {
		return this.complaintsolution;
	}

	public void setComplaintsolution(String complaintsolution) {
		this.complaintsolution = complaintsolution;
	}

	public String getComplaintstatusstatus() {
		return this.complaintstatusstatus;
	}

	public void setComplaintstatusstatus(String complaintstatusstatus) {
		this.complaintstatusstatus = complaintstatusstatus;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public int getCityidref() {
		return cityidref;
	}

	public void setCityidref(int cityidref) {
		this.cityidref = cityidref;
	}

	public String getComplaintername() {
		return complaintername;
	}

	public void setComplaintername(String complaintername) {
		this.complaintername = complaintername;
	}

}