package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.RegionalFormBean;

/**
 * Addresses entity. @author MyEclipse Persistence Tools
 */

public class Addresses implements java.io.Serializable {

	// Fields

	private int addressid;
	private UserDetails UserDetails;
	private String addresstype;
	private String houseno;
	private String street;
	private int cityid;
	private int districtid;
	private int stateid;
	private String cityname;
	private String districtname;
	private String statename;
	private String country;
	private String pincode;
	private String phonetype;
	private String phoneno;
	private String status;
	private int Useridref;

	// Constructors

	/** default constructor */
	public Addresses() {
	}

	public Addresses(RegionalFormBean regionalFormBean) {
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

	/** minimal constructor */
	public Addresses(String phoneno) {
		this.phoneno = phoneno;
	}

	/** full constructor */
	public Addresses(UserDetails UserDetails, String addresstype,
			String houseno, String street, int cityid, String districtname,
			String statename, String country, String pincode, String phonetype,
			String phoneno) {
		this.UserDetails = UserDetails;
		this.addresstype = addresstype;
		this.houseno = houseno;
		this.street = street;
		this.cityid = cityid;
		this.districtname = districtname;
		this.statename = statename;
		this.country = country;
		this.pincode = pincode;
		this.phonetype = phonetype;
		this.phoneno = phoneno;
	}

	// Property accessors

	public UserDetails getUSERDETAILS() {
		return this.UserDetails;
	}

	public void setUSERDETAILS(UserDetails UserDetails) {
		this.UserDetails = UserDetails;
	}

	public String getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getHouseno() {
		return this.houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhonetype() {
		return this.phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public UserDetails getUserDetails() {
		return UserDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		UserDetails = userDetails;
	}

	public int getUseridref() {
		return Useridref;
	}

	public void setUseridref(int useridref) {
		Useridref = useridref;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getDistrictid() {
		return districtid;
	}

	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}