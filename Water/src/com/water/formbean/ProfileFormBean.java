/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.water.formbean;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.water.pojo.UserDetails;

/**
 * MyEclipse Struts Creation date: 09-14-2012
 * 
 * XDoclet definition:
 * 
 * @struts.form name="ProfileFormBean"
 */
public class ProfileFormBean extends ActionForm {
	/*
	 * Generated fields
	 */

	/** lastName property */
	private String lastname;

	/** fax property */
	private String fax;

	/** photograph property */
	private String photograph;

	/** email property */
	private String email;

	/** gender property */
	private String gender;

	/** userName property */
	private String username;

	/** birthDate property */
	private String birthDate;

	/** firstName property */
	private String firstname;

	/** securityquestion property */
	private String securityquestion;

	/** password property */
	private String password;

	/** securityanswer property */
	private String securityanswer;

	/** userType property */
	private String userType;
	private int loginid;
	private UserDetails UserDetails;
	private String loginname;
	private String logintype;
	private String securitycode;
	private int useridref;
	private String 	newpassword;
	private int userid;
	private Date dob;
	private Date dor;
	private String registereddate;
	private String forgotpwquestion;
	private String forgotpwanswer;
	private String emailid;
	private String status;

	/*
	 * Generated Methods
	 */

	/**
	 * Method validate
	 * 
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method reset
	 * 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/**
	 * Returns the fax.
	 * 
	 * @return String
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Set the fax.
	 * 
	 * @param fax
	 *            The fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Returns the photograph.
	 * 
	 * @return String
	 */
	public String getPhotograph() {
		return photograph;
	}

	/**
	 * Set the photograph.
	 * 
	 * @param photograph
	 *            The photograph to set
	 */
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	/**
	 * Returns the email.
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email.
	 * 
	 * @param email
	 *            The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the gender.
	 * 
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the gender.
	 * 
	 * @param gender
	 *            The gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the userName.
	 * 
	 * @return String
	 */

	/**
	 * Returns the birthDate.
	 * 
	 * @return String
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Set the birthDate.
	 * 
	 * @param birthDate
	 *            The birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Returns the securityquestion.
	 * 
	 * @return String
	 */
	public String getSecurityquestion() {
		return securityquestion;
	}

	/**
	 * Set the securityquestion.
	 * 
	 * @param securityquestion
	 *            The securityquestion to set
	 */
	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}

	/**
	 * Returns the password.
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password.
	 * 
	 * @param password
	 *            The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the securityanswer.
	 * 
	 * @return String
	 */
	public String getSecurityanswer() {
		return securityanswer;
	}

	/**
	 * Set the securityanswer.
	 * 
	 * @param securityanswer
	 *            The securityanswer to set
	 */
	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}

	/**
	 * Returns the userType.
	 * 
	 * @return String
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Set the userType.
	 * 
	 * @param userType
	 *            The userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public UserDetails getUserDetails() {
		return UserDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		UserDetails = userDetails;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}

	public int getUseridref() {
		return useridref;
	}

	public void setUseridref(int useridref) {
		this.useridref = useridref;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public String getRegistereddate() {
		return registereddate;
	}

	public void setRegistereddate(String registereddate) {
		this.registereddate = registereddate;
	}

	public String getForgotpwquestion() {
		return forgotpwquestion;
	}

	public void setForgotpwquestion(String forgotpwquestion) {
		this.forgotpwquestion = forgotpwquestion;
	}

	public String getForgotpwanswer() {
		return forgotpwanswer;
	}

	public void setForgotpwanswer(String forgotpwanswer) {
		this.forgotpwanswer = forgotpwanswer;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
}