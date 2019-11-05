package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.RegionalFormBean;

/**
 * District entity. @author MyEclipse Persistence Tools
 */

public class District implements java.io.Serializable {

	// Fields

	private int districtid;
	private State State;
	private int stateid;
	private String districtname;
	private Set CITYs = new HashSet(0);

	// Constructors

	/** default constructor */
	public District() {
	}

	public District(RegionalFormBean regionalFormBean) {
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

	/** full constructor */
	public District(State State, String districtname, Set CITYs) {
		this.State = State;
		this.districtname = districtname;
		this.CITYs = CITYs;
	}

	// Property accessors

	
	public State getSTATE() {
		return this.State;
	}

	public void setSTATE(State State) {
		this.State = State;
	}

	public String getDistrictname() {
		return this.districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public Set getCITYs() {
		return this.CITYs;
	}

	public void setCITYs(Set CITYs) {
		this.CITYs = CITYs;
	}

	public State getState() {
		return State;
	}

	public void setState(State state) {
		State = state;
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

}