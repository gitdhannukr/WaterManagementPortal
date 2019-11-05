package com.water.pojo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Blob;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.RegionalFormBean;
import com.water.formbean.WaterFormBean;

public class WaterBusiness implements Serializable {

	// Fields

	private int cityidref;
	private int businessid;
	private String businessfor;
	private String wateramount;
	private String waterliters;
	private String waterdesc;

	// Constructors

	public WaterBusiness() {
	}

	public WaterBusiness(WaterFormBean waterFormBean) {
		Map map;
		try {
			map = BeanUtils.describe(waterFormBean);
			BeanUtils.populate(this, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public int getCityidref() {
		return cityidref;
	}

	public void setCityidref(int cityidref) {
		this.cityidref = cityidref;
	}

	public int getBusinessid() {
		return businessid;
	}

	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}

	public String getBusinessfor() {
		return businessfor;
	}

	public void setBusinessfor(String businessfor) {
		this.businessfor = businessfor;
	}

	public String getWateramount() {
		return wateramount;
	}

	public void setWateramount(String wateramount) {
		this.wateramount = wateramount;
	}

	public String getWaterliters() {
		return waterliters;
	}

	public void setWaterliters(String waterliters) {
		this.waterliters = waterliters;
	}

	public String getWaterdesc() {
		return waterdesc;
	}

	public void setWaterdesc(String waterdesc) {
		this.waterdesc = waterdesc;
	}

}
