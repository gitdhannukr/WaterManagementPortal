package com.water.formbean;

import org.apache.struts.action.ActionForm;

public class WaterFormBean extends ActionForm {

	private String colonyname;
	private String division;
	private String colony;
	private String areatype;
	private String fromtime;
	private String totime;
	private String supplypattrn;
	private String lineman;
	private String contactaddresses;
	private int supplyid;

	private int id;
	private int cityid;
	private String header;
	private String information;
	private String filepath;
	private String filetype;
	private String water;

	private int cityidref;
	private int businessid;
	private String businessfor;
	private String wateramount;
	private String waterliters;
	private String waterdesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String url;

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

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
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
