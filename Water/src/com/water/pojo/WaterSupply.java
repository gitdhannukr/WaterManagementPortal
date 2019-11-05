package com.water.pojo;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.RegionalFormBean;
import com.water.formbean.WaterFormBean;

public class WaterSupply {
	
	private int supplyid;
	private String colonyname;
	private String division;
	private String colony;
	private String areatype;
	private String fromtime;
	private String totime;
	private String supplypattrn;
	private String lineman;
	private String contactaddresses;
	private int cityidref;

	
	public WaterSupply(){}
	
	
	public WaterSupply(WaterFormBean waterFormBean) {
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
	
	
	public int getSupplyid() {
		return supplyid;
	}


	public void setSupplyid(int supplyid) {
		this.supplyid = supplyid;
	}


	public String getColonyname() {
		return colonyname;
	}

	public void setColonyname(String colonyname) {
		this.colonyname = colonyname;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getAreatype() {
		return areatype;
	}

	public void setAreatype(String areatype) {
		this.areatype = areatype;
	}

	public String getFromtime() {
		return fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}

	public String getTotime() {
		return totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}

	public String getSupplypattrn() {
		return supplypattrn;
	}

	public void setSupplypattrn(String supplypattrn) {
		this.supplypattrn = supplypattrn;
	}

	public String getLineman() {
		return lineman;
	}

	public void setLineman(String lineman) {
		this.lineman = lineman;
	}

	public String getContactaddresses() {
		return contactaddresses;
	}

	public void setContactaddresses(String contactaddresses) {
		this.contactaddresses = contactaddresses;
	}

	public int getCityidref() {
		return cityidref;
	}

	public void setCityidref(int cityidref) {
		this.cityidref = cityidref;
	}

}
