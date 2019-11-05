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
 * State entity. @author MyEclipse Persistence Tools
 */

public class State implements java.io.Serializable {

	// Fields
	private int stateid;
	private String statename;

	// Constructors

	/** default constructor */
	public State() {
	}

	public State(State state) {
		this.setStateid(state.getStateid());
		this.setStatename(state.getStatename());
	}

	public State(RegionalFormBean regionalFormBean) {
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

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

}