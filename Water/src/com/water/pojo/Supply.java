package com.water.pojo;
// default package

import java.math.BigDecimal;

/**
 * Supply entity. @author MyEclipse Persistence Tools
 */

public class Supply  implements java.io.Serializable {

	// Fields

	private BigDecimal supplyid;
	private City City;
	private String nameofdevision;
	private String nameodarea;
	private String areatype;
	private String fromtime;
	private String totime;
	private String supplypatters;
	private String linemanname;
	private int Cityidref;
	// Constructors

	/** default constructor */
	public Supply() {
	}

	/** full constructor */
	public Supply(City City, String nameofdevision, String nameodarea,
			String areatype, String fromtime, String totime,
			String supplypatters, String linemanname) {
		this.City = City;
		this.nameofdevision = nameofdevision;
		this.nameodarea = nameodarea;
		this.areatype = areatype;
		this.fromtime = fromtime;
		this.totime = totime;
		this.supplypatters = supplypatters;
		this.linemanname = linemanname;
	}

	// Property accessors

	public BigDecimal getSupplyid() {
		return this.supplyid;
	}

	public void setSupplyid(BigDecimal supplyid) {
		this.supplyid = supplyid;
	}

	public City getCITY() {
		return this.City;
	}

	public void setCITY(City City) {
		this.City = City;
	}

	public String getNameofdevision() {
		return this.nameofdevision;
	}

	public void setNameofdevision(String nameofdevision) {
		this.nameofdevision = nameofdevision;
	}

	public String getNameodarea() {
		return this.nameodarea;
	}

	public void setNameodarea(String nameodarea) {
		this.nameodarea = nameodarea;
	}

	public String getAreatype() {
		return this.areatype;
	}

	public void setAreatype(String areatype) {
		this.areatype = areatype;
	}

	public String getFromtime() {
		return this.fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}

	public String getTotime() {
		return this.totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}

	public String getSupplypatters() {
		return this.supplypatters;
	}

	public void setSupplypatters(String supplypatters) {
		this.supplypatters = supplypatters;
	}

	public String getLinemanname() {
		return this.linemanname;
	}

	public void setLinemanname(String linemanname) {
		this.linemanname = linemanname;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public int getCityidref() {
		return Cityidref;
	}

	public void setCityidref(int cityidref) {
		Cityidref = cityidref;
	}

}