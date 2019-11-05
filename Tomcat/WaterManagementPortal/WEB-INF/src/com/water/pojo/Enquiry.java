package com.water.pojo;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.GeneralFormBean;

// default package

/**
 * Enquiry entity. @author MyEclipse Persistence Tools
 */

public class Enquiry implements java.io.Serializable {

	// Fields

	private City City;
	private String enquiryarea;
	private String enquiry;
	private String enquiryreply;
	private int cityidref;
	private String enquirystatus;
	private int enquiryid;

	// Constructors

	/** default constructor */
	public Enquiry() {
	}

	/** full constructor */
	public Enquiry(City City, String enquiryarea, String enquiry,
			String enquiryreply) {
		this.City = City;
		this.enquiryarea = enquiryarea;
		this.enquiry = enquiry;
		this.enquiryreply = enquiryreply;
	}

	public Enquiry(GeneralFormBean generalFormBean) {
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

	// Property accessors

	public City getCity() {
		return this.City;
	}

	public void setCity(City City) {
		this.City = City;
	}

	public String getEnquiryarea() {
		return this.enquiryarea;
	}

	public void setEnquiryarea(String enquiryarea) {
		this.enquiryarea = enquiryarea;
	}

	public String getEnquiry() {
		return this.enquiry;
	}

	public void setEnquiry(String enquiry) {
		this.enquiry = enquiry;
	}

	public String getEnquiryreply() {
		return this.enquiryreply;
	}

	public void setEnquiryreply(String enquiryreply) {
		this.enquiryreply = enquiryreply;
	}

	public int getCityidref() {
		return cityidref;
	}

	public void setCityidref(int cityidref) {
		this.cityidref = cityidref;
	}

	public String getEnquirystatus() {
		return enquirystatus;
	}

	public void setEnquirystatus(String enquirystatus) {
		this.enquirystatus = enquirystatus;
	}

	public int getEnquiryid() {
		return enquiryid;
	}

	public void setEnquiryid(int enquiryid) {
		this.enquiryid = enquiryid;
	}

}