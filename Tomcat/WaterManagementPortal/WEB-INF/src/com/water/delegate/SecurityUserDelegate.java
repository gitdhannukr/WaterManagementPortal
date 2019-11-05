package com.water.delegate;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.LoginException;
import com.water.formbean.ProfileFormBean;
import com.water.pojo.LoginDetails;
import com.water.pojo.UserDetails;
import com.water.servicei.SecurityServiceI;
import com.water.servicei.impl.SecurityServiceImpl;

public class SecurityUserDelegate {

	SecurityServiceI securityServiceI = new SecurityServiceImpl();

	public String checkUser(String loginid) throws ConnectionException {
		return securityServiceI.checkUser(loginid);
	}

	public boolean userRegistration(UserDetails userDetails)
			throws ConnectionException, FileNotFoundException, SQLException {
		return securityServiceI.userRegistration(userDetails);
	}

	public LoginDetails loginCheck(LoginDetails loginDetails)
			throws ConnectionException, LoginException {
		return securityServiceI.loginCheck(loginDetails);
	}

	public boolean passwordRecovery(UserDetails userDetails)
			throws ConnectionException {
		return securityServiceI.passwordRecovery(userDetails);
	}

	public boolean newPassword(LoginDetails loginDetails)
			throws ConnectionException {
		return securityServiceI.newPassword(loginDetails);
	}

	public boolean changePass(LoginDetails loginDetails)
			throws ConnectionException {
		return securityServiceI.changePass(loginDetails);
	}

	public UserDetails viewUserProfile(int userid, String path)
			throws ConnectionException {
		return securityServiceI.viewUserProfile(userid, path);
	}

	public Vector<UserDetails> viewUserList(String user, String path)
			throws ConnectionException {
		return securityServiceI.viewUserList(user, path);
	}

	public boolean deleteUsers(int userid) throws ConnectionException {
		return securityServiceI.deleteUsers(userid);
	}

}
