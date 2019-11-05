package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.GeneralFormBean;
import com.water.formbean.RegionalFormBean;

/**
 * Education entity. @author MyEclipse Persistence Tools
 */

public class Education implements java.io.Serializable {

	// Fields

	private int educationid;
	private String educationname;
	private String educationdescription;
	private String educationdocumentaion;
	private Blob educationdoc;
	private String siteurl;
	private City City;

	// Constructors

	/** default constructor */
	public Education() {
	}

	public Education(GeneralFormBean generalFormBean) {
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
	public Education(City City, String educationname,
			String educationdescription, String educationdocumentaion,
			String siteurl) {
		this.City = City;
		this.educationname = educationname;
		this.educationdescription = educationdescription;
		this.educationdocumentaion = educationdocumentaion;
		this.siteurl = siteurl;
	}

	// Property accessors

	public City getCITY() {
		return this.City;
	}

	public int getEducationid() {
		return educationid;
	}

	public void setEducationid(int educationid) {
		this.educationid = educationid;
	}

	public void setCITY(City City) {
		this.City = City;
	}

	public String getEducationname() {
		return this.educationname;
	}

	public void setEducationname(String educationname) {
		this.educationname = educationname;
	}

	public String getEducationdescription() {
		return this.educationdescription;
	}

	public void setEducationdescription(String educationdescription) {
		this.educationdescription = educationdescription;
	}

	public String getEducationdocumentaion() {
		return this.educationdocumentaion;
	}

	public void setEducationdocumentaion(String educationdocumentaion) {
		this.educationdocumentaion = educationdocumentaion;
	}

	public String getSiteurl() {
		return this.siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public Blob getEducationdoc() {
		return educationdoc;
	}

	public void setEducationdoc(Blob educationdoc) {
		this.educationdoc = educationdoc;
	}

}