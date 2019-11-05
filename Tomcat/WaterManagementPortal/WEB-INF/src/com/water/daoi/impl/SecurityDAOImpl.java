package com.water.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.water.dao.BaseHibernateDAO;
import com.water.dao.HQLConstants;
import com.water.daoi.SecurityDAOI;
import com.water.exception.ConnectionException;
import com.water.exception.LoginException;
import com.water.formbean.ProfileFormBean;
import com.water.pojo.Addresses;
import com.water.pojo.LoginDetails;
import com.water.pojo.UserDetails;
import com.water.util.DateUtil;
import com.water.util.DateWrapper;
import com.water.util.UtilConstants;

public class SecurityDAOImpl extends BaseHibernateDAO implements SecurityDAOI {
	boolean flag = false;
	Session session = null;
	private static final Log log = LogFactory.getLog(SecurityDAOImpl.class);

	public String checkUser(String loginid) throws ConnectionException {
		String username = "";
		try {
			Query query = getSession().createQuery(HQLConstants._CHECK_USER);
			query.setString(0, loginid);
			Iterator it = query.iterate();
			if (it.hasNext()) {
				username = (String) it.next();
			} else {
				username = "";
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
			username = "";
		} catch (HibernateException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		}
		return username;
	}

	public boolean userRegistration(UserDetails userDetails)
			throws ConnectionException, SQLException, FileNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			LoginDetails loginDetails = userDetails.getLoginDetails();
			Addresses addresses = userDetails.getAddresses();
			System.out.println(userDetails.getFirstname());
			System.out.println(userDetails.getLastname());
			System.out.println(loginDetails.getLoginname());
			Connection connection = session.connection();
			CallableStatement query = connection
					.prepareCall(" { call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

			File file = new File(userDetails.getPhotograph());
			FileInputStream fileInputStream = new FileInputStream(file);
			query.setBinaryStream(1, fileInputStream, (int) file.length());

			query.setString(2, userDetails.getFirstname());
			query.setString(3, userDetails.getLastname());
			query.setString(4, DateWrapper
					.parseDate(userDetails.getBirthDate()));
			query.setString(5, userDetails.getForgotpwquestion());
			query.setString(6, userDetails.getForgotpwanswer());
			query.setString(7, userDetails.getEmailid());
			query.setString(8, userDetails.getGender());
			query.setString(9, loginDetails.getLoginname());
			query.setString(10, loginDetails.getPassword());
			query.setString(11, loginDetails.getLogintype());
			query.setString(12, addresses.getAddresstype());
			query.setString(13, addresses.getHouseno());
			query.setString(14, addresses.getStreet());
			query.setInt(15, addresses.getCityid());
			query.setString(16, addresses.getDistrictname());
			query.setString(17, addresses.getStatename());
			query.setString(18, addresses.getCountry());
			query.setString(19, addresses.getPincode());
			query.setString(20, addresses.getPhoneno());
			query.setString(21, addresses.getPhonetype());
			query.execute();
			transaction.commit();
			flag = true;

		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public LoginDetails loginCheck(LoginDetails loginDetails)
			throws ConnectionException, LoginException {
		LoginDetails loginDetails2 = null;
		try {
			List query = getSession().createQuery(HQLConstants._LOGIN_CHECK)
					.setParameter(0, loginDetails.getLoginname()).setString(1,
							loginDetails.getPassword()).list();
			if (!query.equals("")) {
				Iterator iterator = query.iterator();
				loginDetails2 = (LoginDetails) iterator.next();
			}
		} catch (NoSuchElementException e) {
			throw new LoginException("Invalid UserName & Password");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		}
		return loginDetails2;
	}

	public boolean passwordRecovery(UserDetails userDetails)
			throws ConnectionException {
		try {
			Query query = getSession()
					.createQuery(HQLConstants._PASSWORD_CHECK);
			query.setString(0, userDetails.getLoginname());
			query.setString(1, userDetails.getForgotpwquestion());
			query.setString(2, userDetails.getForgotpwanswer());
			Iterator it = query.iterate();
			if (it.hasNext()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (NoSuchElementException e) {
			throw new ConnectionException(
					"Your Giving details are wrong please try again.....");
		} catch (HibernateException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		}
		return flag;
	}

	public boolean newPassword(LoginDetails loginDetails)
			throws ConnectionException {
		boolean flag = true;
		try {
			System.out.println(loginDetails.getPassword());
			System.out.println(loginDetails.getLoginname());
			session = getSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(HQLConstants._NEW_PASSWORD);
			query.setString("password", loginDetails.getPassword());
			query.setString("loginname", loginDetails.getLoginname());
			int result = query.executeUpdate();
			if (result > 0) {
				flag = true;
				transaction.commit();
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException("server busy please try later.......");
		}
		return flag;
	}

	public boolean changePass(LoginDetails loginDetails)
			throws ConnectionException {
		boolean flag = false;
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			System.out.println(loginDetails.getNewpassword());
			System.out.println(loginDetails.getLoginname());
			System.out.println(loginDetails.getPassword());
			String HQL_QUERY = "update LoginDetails set password=:password where loginname=:loginname and password=:oldpassword";
			Query query = session.createQuery(HQL_QUERY);
			query.setString("password", loginDetails.getNewpassword());
			query.setString("loginname", loginDetails.getLoginname());
			query.setString("oldpassword", loginDetails.getPassword());
			int result = query.executeUpdate();
			if (result > 0) {
				flag = true;
				transaction.commit();
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"server busy please try latter.......");
		}
		return flag;
	}

	public UserDetails viewUserProfile(int userid, String path)
			throws ConnectionException {
		UserDetails userProfileFormBean = null;
		Addresses addresses = null;
		try {
			session = getSession();
			Connection connection = session.connection();
			String SQL_QUERY = "select userdetails.userid,userdetails.firstname,userdetails.lastname,userdetails.dob,userdetails.emailid,userdetails.photograph,userdetails.gender,address.addressid,address.addresstype,address.houseno,address.street,address.city,address.district,address.state,address.country,address.pincode,address.phonetype,address.phoneno	from UserDetails userdetails,Addresses address where userdetails.userid=address.useridref and userdetails.userid=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(SQL_QUERY);

			preparedStatement.setInt(1, userid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String realpath = "";
				userProfileFormBean = new UserDetails();
				addresses = new Addresses();
				userProfileFormBean.setUserid(resultSet.getInt(1));
				userProfileFormBean.setFirstname(resultSet.getString(2));
				userProfileFormBean.setLastname(resultSet.getString(3));
				userProfileFormBean.setBirthDate(DateUtil.parseDate(resultSet
						.getString(4)));
				userProfileFormBean.setEmailid(resultSet.getString(5));

				Blob b = resultSet.getBlob(6);
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + resultSet.getInt(1) + ".jpg";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				userProfileFormBean.setPhotograph(realpath);

				userProfileFormBean.setGender(resultSet.getString(7));
				addresses.setAddressid(resultSet.getInt(8));
				addresses.setAddresstype(resultSet.getString(9));
				addresses.setHouseno(resultSet.getString(10));
				addresses.setStreet(resultSet.getString(11));
				addresses.setCityid(resultSet.getInt(12));
				addresses.setDistrictname(resultSet.getString(13));
				addresses.setStatename(resultSet.getString(14));
				addresses.setCountry(resultSet.getString(15));
				addresses.setPincode(resultSet.getString(16));
				addresses.setPhonetype(resultSet.getString(17));
				addresses.setPhoneno(resultSet.getString(18));
				userProfileFormBean.setAddresses(addresses);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (HibernateException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		}
		return userProfileFormBean;
	}

	public Vector<UserDetails> viewUserList(String user, String path)
			throws ConnectionException {
		Vector<UserDetails> vUserDetails = new Vector<UserDetails>();
		UserDetails userDetails = null;
		Addresses address = null;
		String HQL_QUERY = "";
		try {
			session = getSession();
			Connection connection = session.connection();
			if (user.equalsIgnoreCase("Active"))
				HQL_QUERY = "select profile.userid,profile.firstname,profile.lastname,profile.dob,profile.emailid,profile.photograph,profile.gender,address.addressid,address.addresstype,address.houseno,address.street,address.city,address.district,address.state,address.country,address.pincode,address.phonetype,address.phoneno,profile.status from  UserDetails profile,Addresses address where profile.userid=address.useridref  and profile.status='Active'";
			else
				HQL_QUERY = "select profile.userid,profile.firstname,profile.lastname,profile.dob,profile.emailid,profile.photograph,profile.gender,address.addressid,address.addresstype,address.houseno,address.street,address.city,address.district,address.state,address.country,address.pincode,address.phonetype,address.phoneno,profile.status from  UserDetails profile,Addresses address where profile.userid=address.useridref  and profile.status='Request'";

			PreparedStatement preparedStatement = connection
					.prepareStatement(HQL_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userDetails = new UserDetails();
				String realpath = "";
				address = new Addresses();
				userDetails.setUserid(resultSet.getInt(1));
				userDetails.setFirstname(resultSet.getString(2));
				userDetails.setLastname(resultSet.getString(3));
				userDetails.setBirthDate(DateUtil.parseDate(resultSet
						.getString(4)));
				userDetails.setEmailid(resultSet.getString(5));
				try {
					Blob b = resultSet.getBlob(6);
					byte b1[] = b.getBytes(1, (int) b.length());
					realpath = path + "/" + resultSet.getInt(1) + ".jpg";
					System.out.println("path  :" + path);
					OutputStream fout = new FileOutputStream(realpath);
					fout.write(b1);
				} catch (NullPointerException e) {
					realpath = path + "/abc.jpg";

				}

				userDetails.setPhotograph(realpath);

				userDetails.setGender(resultSet.getString(7));

				address.setAddressid(resultSet.getInt(8));
				address.setAddresstype(resultSet.getString(9));
				address.setHouseno(resultSet.getString(10));
				address.setStreet(resultSet.getString(11));
				address.setCityid(resultSet.getInt(12));
				address.setDistrictname(resultSet.getString(13));
				address.setStatename(resultSet.getString(14));
				address.setCountry(resultSet.getString(15));
				address.setPincode(resultSet.getString(16));
				address.setPhonetype(resultSet.getString(17));
				address.setPhoneno(resultSet.getString(18));
				address.setStatus(resultSet.getString(19));
				userDetails.setAddresses(address);
				vUserDetails.add(userDetails);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (HibernateException e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		}
		return vUserDetails;
	}

	public boolean deleteUsers(int userid) throws ConnectionException {
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();

			String HQL_QUERY = "update UserDetails set status='Request' where userid=:userid";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger("userid", userid);
			int result = query.executeUpdate();
			if (result > 0) {
				flag = true;
				tx.commit();
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

}
