package com.water.pojo;
// default package

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.water.formbean.ProfileFormBean;
import com.water.formbean.RegionalFormBean;

/**
 * LoginDetails entity. @author MyEclipse Persistence Tools
 */

public class LoginDetails  implements java.io.Serializable {

	// Fields

	private int loginid;
	private UserDetails UserDetails;
	private String loginname;
	private String password;
	private String logintype;
	private String newpassword;
	private String securitycode;
	private int  useridref;

	// Constructors

	/** default constructor */
	public LoginDetails() {
	}
	public LoginDetails(ProfileFormBean profileFormBean) {
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
	public LoginDetails(String password, String logintype, String securitycode) {
		this.password = password;
		this.logintype = logintype;
		this.securitycode = securitycode;
	}

	/** full constructor */
	public LoginDetails(UserDetails UserDetails, String loginname,
			String password, String logintype, String securitycode) {
		this.UserDetails = UserDetails;
		this.loginname = loginname;
		this.password = password;
		this.logintype = logintype;
		this.securitycode = securitycode;
	}

	// Property accessors

	

	public UserDetails getUSERDETAILS() {
		return this.UserDetails;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public void setUSERDETAILS(UserDetails UserDetails) {
		this.UserDetails = UserDetails;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogintype() {
		return this.logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getSecuritycode() {
		return this.securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}

	public UserDetails getUserDetails() {
		return UserDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		UserDetails = userDetails;
	}

	public int getUseridref() {
		return useridref;
	}

	public void setUseridref(int useridref) {
		this.useridref = useridref;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

}