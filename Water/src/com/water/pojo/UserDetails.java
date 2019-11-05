package com.water.pojo;

// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.ProfileFormBean;

/**
 * UserDetails entity. @author MyEclipse Persistence Tools
 */

public class UserDetails implements java.io.Serializable {

	// Fields

	private int userid;
	private String firstname;
	private String lastname;
	private Date dob;
	private Date dor;
	private String birthDate;
	private String registereddate;
	private String forgotpwquestion;
	private String forgotpwanswer;
	private String photograph;
	private String emailid;
	private String gender;
	private String status;
	private String loginname;
	private LoginDetails LoginDetails;
	private Addresses Addresses;

	// Constructors

	/** default constructor */
	public UserDetails() {
	}

	public UserDetails(ProfileFormBean profileFormBean) {
		Map map;
		try {
			map = BeanUtils.describe(profileFormBean);
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
	public UserDetails(String firstname, String lastname, Date dob,
			String forgotpwquestion, String forgotpwanswer, String status) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.forgotpwquestion = forgotpwquestion;
		this.forgotpwanswer = forgotpwanswer;
		this.status = status;
	}

	/** full constructor */
	public UserDetails(String firstname, String lastname, Date dob, Date dor,
			String forgotpwquestion, String forgotpwanswer, String photograph,
			String emailid, String gender, String status,
			LoginDetails LoginDetails, Addresses Addresses) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.dor = dor;
		this.forgotpwquestion = forgotpwquestion;
		this.forgotpwanswer = forgotpwanswer;
		this.photograph = photograph;
		this.emailid = emailid;
		this.gender = gender;
		this.status = status;
		this.Addresses = Addresses;
		this.LoginDetails = LoginDetails;

	}

	// Property accessors

	

	public String getFirstname() {
		return this.firstname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDor() {
		return this.dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public String getForgotpwquestion() {
		return this.forgotpwquestion;
	}

	public void setForgotpwquestion(String forgotpwquestion) {
		this.forgotpwquestion = forgotpwquestion;
	}

	public String getForgotpwanswer() {
		return this.forgotpwanswer;
	}

	public void setForgotpwanswer(String forgotpwanswer) {
		this.forgotpwanswer = forgotpwanswer;
	}

	public String getPhotograph() {
		return this.photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoginDetails getLoginDetails() {
		return LoginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		LoginDetails = loginDetails;
	}

	public Addresses getAddresses() {
		return Addresses;
	}

	public void setAddresses(Addresses addresses) {
		Addresses = addresses;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getRegistereddate() {
		return registereddate;
	}

	public void setRegistereddate(String registereddate) {
		this.registereddate = registereddate;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

}