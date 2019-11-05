package com.water.servicei.impl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.water.daoi.RegionalDAOI;
import com.water.daoi.SecurityDAOI;
import com.water.daoi.impl.RegionalDAOImpl;
import com.water.daoi.impl.SecurityDAOImpl;
import com.water.exception.ConnectionException;
import com.water.exception.LoginException;
import com.water.formbean.ProfileFormBean;
import com.water.pojo.LoginDetails;
import com.water.pojo.UserDetails;
import com.water.servicei.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI {
	SecurityDAOI securityDAOI = new SecurityDAOImpl();

	public String checkUser(String loginid) throws ConnectionException {
		return securityDAOI.checkUser(loginid);
	}

	public boolean userRegistration(UserDetails userDetails)
			throws ConnectionException, FileNotFoundException, SQLException {
		return securityDAOI.userRegistration(userDetails);
	}

	public LoginDetails loginCheck(LoginDetails loginDetails)
			throws ConnectionException, LoginException {
		return securityDAOI.loginCheck(loginDetails);
	}

	public boolean passwordRecovery(UserDetails userDetails)
			throws ConnectionException {
		return securityDAOI.passwordRecovery(userDetails);
	}

	public boolean newPassword(LoginDetails loginDetails)
			throws ConnectionException {
		return securityDAOI.newPassword(loginDetails);
	}

	public boolean changePass(LoginDetails loginDetails)
			throws ConnectionException {
		return securityDAOI.changePass(loginDetails);
	}

	public UserDetails viewUserProfile(int userid, String path)
			throws ConnectionException {
		return securityDAOI.viewUserProfile(userid, path);
	}

	public Vector<UserDetails> viewUserList(String userid, String path)
			throws ConnectionException {
		return securityDAOI.viewUserList(userid, path);
	}

	public boolean deleteUsers(int userid) throws ConnectionException {
		return securityDAOI.deleteUsers(userid);
	}
}
