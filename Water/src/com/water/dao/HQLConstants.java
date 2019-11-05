package com.water.dao;

public class HQLConstants {
	public static final String _VIEW_STATES = "from State";
	public static final String _VIEW_DISTRICT = "from District where stateid=?";
	public static final String _VIEW_CITY = "from City where stateid=? and districtid=?";
	public static final String _VIEW_CITY_UPDATE = "from City where districtid=?";
	public static final String _CHECK_USER = "select loginname from LoginDetails where loginname=?";
	public static final String _LOGIN_CHECK = "select login from LoginDetails login,UserDetails userdetails where login.loginname=? and login.password=? and login.useridref=userdetails.userid and userdetails.status='Active'";
	public static final String _PASSWORD_CHECK = "select  login.password from LoginDetails login,UserDetails userdetails where login.loginname=? and userdetails.forgotpwquestion=? and userdetails.forgotpwanswer=?";
	public static final String _NEW_PASSWORD = "update LoginDetails set password=:password where loginname=:loginname";
	public static final String _CHANGE_PASSWORD = "update LoginDetails set password=:password where loginname=:loginname and password=:oldpassword";

	public static final String _VIEW_TIPS = "from TipsSuggestions where cityidref=?";
	public static final String _VIEW_FEEDBACK = "from Feedback where cityidref=?";
	public static final String _VIEW_ENQUIRY = "from Enquiry where cityidref=?";
	public static final String _VIEW_EDUCATION = "from Education";
	public static final String _VIEW_COMPLAINTS = "from Complaints where cityidref=?";
	public static final String _WATER_COST = "from WaterBusiness where cityidref=? and businessfor=?";
	public static final String _WATER_SUPPLY = "from WaterSupply where cityidref=?";
	public static final String _WATER_INFORMATION = "from WaterInfoPojo where cityid=? and INFORMATIONTYPE=?";
	public static final String _WATER_COST_VIEW = "from WaterBusiness where businessid=?";
}
