package com.water.dao;

public class SqlConstants {
public static final String _loginCheck="SELECT LOGINTYPE FROM Logindetails WHERE LOGINNAME=? AND PASSWORD=?";
public static final String _GETUSERID="SELECT LOGINID FROM Logindetails WHERE LOGINNAME=? AND PASSWORD=?";
public static final String _insert_bank="INSERT INTO BANK_LOCKER VALUES((SELECT NVL(MAX(BID),0)+1 FROM BANK_LOCKER),?,?,?,?)";
}
