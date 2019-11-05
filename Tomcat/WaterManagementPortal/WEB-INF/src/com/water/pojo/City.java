package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.RegionalFormBean;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private int cityid;
	private int stateid;
	private int districtid;
	private String cityname;
	private String citydescription;
	private Blob citymap;
	private String imagepath;

	// Constructors

	/** default constructor */
	public City() {
	}

	public City(RegionalFormBean regionalFormBean) {
		Map map;
		try {
			map = BeanUtils.describe(regionalFormBean);
			BeanUtils.populate(this, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public int getDistrictid() {
		return districtid;
	}

	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCitydescription() {
		return citydescription;
	}

	public void setCitydescription(String citydescription) {
		this.citydescription = citydescription;
	}

	public Blob getCitymap() {
		return citymap;
	}

	public void setCitymap(Blob citymap) {
		this.citymap = citymap;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	// Property accessors


}