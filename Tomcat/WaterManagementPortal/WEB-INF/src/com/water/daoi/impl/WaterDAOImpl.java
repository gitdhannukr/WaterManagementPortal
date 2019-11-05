package com.water.daoi.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.water.dao.BaseHibernateDAO;
import com.water.dao.HQLConstants;
import com.water.daoi.WaterDAOI;
import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.City;
import com.water.pojo.WaterInfoPojo;
import com.water.pojo.WaterSupply;
import com.water.util.UtilConstants;

public class WaterDAOImpl extends BaseHibernateDAO implements WaterDAOI {
	boolean flag = false;
	Session session = null;
	private static final Log log = LogFactory.getLog(RegionalDAOImpl.class);

	public boolean addWaterSupplyDetails(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(waterSupply);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List viewWaterSupplyDetails(int cityid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting WaterSupply instance with id: " + cityid);
		System.out.println(cityid);
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._WATER_SUPPLY);
			queryObject.setInteger(0, cityid);
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteWaterSupplyRecord(int supplyid)
			throws ConnectionException, DataNotFoundException {
		log.debug("getting WaterSupply instance with id: " + supplyid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			WaterSupply instance = (WaterSupply) session.get(WaterSupply.class,
					supplyid);
			session.delete(instance);
			transaction.commit();
			flag = true;
			log.debug("delete successful");
			getSession().close();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public WaterSupply viewWaterSupplyUpdate(int supplyid)
			throws ConnectionException, DataNotFoundException {
		log.debug("getting WaterSupply instance with id: " + supplyid);
		WaterSupply waterSupply = null;
		try {
			WaterSupply instance = (WaterSupply) getSession().get(
					WaterSupply.class, supplyid);
			return instance;
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
	}

	public boolean updateWaterSupply(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException {
		log.debug("attaching dirty WaterSupply instance");
		try {
			System.out.println(waterSupply.getSupplyid());
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			WaterSupply instance = (WaterSupply) session.get(WaterSupply.class,
					waterSupply.getSupplyid());
			instance.setColonyname(waterSupply.getColonyname());
			instance.setDivision(waterSupply.getDivision());
			instance.setAreatype(waterSupply.getAreatype());
			instance.setFromtime(waterSupply.getFromtime());
			instance.setTotime(waterSupply.getTotime());
			instance.setSupplypattrn(waterSupply.getSupplypattrn());
			instance.setLineman(waterSupply.getLineman());
			instance.setContactaddresses(waterSupply.getContactaddresses());
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("attach failed", re);
			System.out.println(re);
			throw re;
		}
		return flag;
	}

	public boolean addWaterInforamtion(WaterInfoPojo waterInfoPojo)
			throws ConnectionException, DataNotFoundException,
			FileNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(waterInfoPojo);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List viewWaterInformation(int cityid, String water)
			throws ConnectionException, DataNotFoundException {
		log.debug("getting WaterInfo instance with id: " + cityid);
		System.out.println(cityid);
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._WATER_INFORMATION);
			queryObject.setInteger(0, cityid);
			queryObject.setString(1, water);
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteWaterInformation(int id) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting WaterSupply instance with id: " + id);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			WaterInfoPojo instance = (WaterInfoPojo) session.get(
					WaterInfoPojo.class, id);
			session.delete(instance);
			transaction.commit();
			flag = true;
			log.debug("delete successful");
			getSession().close();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}
}
