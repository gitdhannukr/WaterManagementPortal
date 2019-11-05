package com.water.servicei;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.LoginException;
import com.water.formbean.ProfileFormBean;
import com.water.pojo.LoginDetails;
import com.water.pojo.UserDetails;

public interface SecurityServiceI {
	public String checkUser(String loginid) throws ConnectionException;

	public boolean userRegistration(UserDetails userDetails)
			throws ConnectionException, FileNotFoundException, SQLException;

	public LoginDetails loginCheck(LoginDetails loginDetails)
			throws ConnectionException, LoginException;

	public boolean passwordRecovery(UserDetails userDetails)
			throws ConnectionException;

	public boolean newPassword(LoginDetails loginDetails)
			throws ConnectionException;

	public boolean changePass(LoginDetails loginDetails)
			throws ConnectionException;

	public UserDetails viewUserProfile(int userid, String path)
			throws ConnectionException;

	public Vector<UserDetails> viewUserList(String user, String path)
			throws ConnectionException;

	public boolean deleteUsers(int userid) throws ConnectionException;
}
