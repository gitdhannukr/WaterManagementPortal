package com.water.pojo;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.GeneralFormBean;
import com.water.formbean.RegionalFormBean;

// default package

/**
 * TipsSuggestions entity. @author MyEclipse Persistence Tools
 */

public class TipsSuggestions implements java.io.Serializable {

	// Fields

	private int suggesstionid;
	private City City;
	private int cityidref;
	private String citizenname;
	private String emailid;
	private String suggestonsdescription;

	// Constructors

	/** default constructor */
	public TipsSuggestions() {
	}

	public TipsSuggestions(GeneralFormBean generalFormBean) {
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
	public TipsSuggestions(City City, String citizenname, String emailid,
			String suggestonsdescription) {
		this.City = City;
		this.citizenname = citizenname;
		this.emailid = emailid;
		this.suggestonsdescription = suggestonsdescription;
	}

	// Property accessors


	public City getCITY() {
		return this.City;
	}

	public void setCITY(City City) {
		this.City = City;
	}

	public String getCitizenname() {
		return this.citizenname;
	}

	public void setCitizenname(String citizenname) {
		this.citizenname = citizenname;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getSuggestonsdescription() {
		return this.suggestonsdescription;
	}

	public void setSuggestonsdescription(String suggestonsdescription) {
		this.suggestonsdescription = suggestonsdescription;
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

	public int getSuggesstionid() {
		return suggesstionid;
	}

	public void setSuggesstionid(int suggesstionid) {
		this.suggesstionid = suggesstionid;
	}

}