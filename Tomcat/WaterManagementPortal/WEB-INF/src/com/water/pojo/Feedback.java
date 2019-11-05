package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.GeneralFormBean;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {

	// Fields

	private int feedbackid;
	private City City;
	private String feedbackitem;
	private String feedsendername;
	private String feedbackdescription;
	private int cityidref;

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	public Feedback(GeneralFormBean generalFormBean) {
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
	public Feedback(City City, String feedbackitem, String feedsendername,
			String feedbackdescription) {
		this.City = City;
		this.feedbackitem = feedbackitem;
		this.feedsendername = feedsendername;
		this.feedbackdescription = feedbackdescription;
	}

	// Property accessors

	public City getCITY() {
		return this.City;
	}

	public void setCITY(City City) {
		this.City = City;
	}

	public String getFeedbackitem() {
		return this.feedbackitem;
	}

	public void setFeedbackitem(String feedbackitem) {
		this.feedbackitem = feedbackitem;
	}

	public String getFeedsendername() {
		return this.feedsendername;
	}

	public void setFeedsendername(String feedsendername) {
		this.feedsendername = feedsendername;
	}

	public String getFeedbackdescription() {
		return this.feedbackdescription;
	}

	public void setFeedbackdescription(String feedbackdescription) {
		this.feedbackdescription = feedbackdescription;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public int getCityidref() {
		return cityidref;
	}

	public void setCityidref(int cityidref) {
		this.cityidref = cityidref;
	}

}