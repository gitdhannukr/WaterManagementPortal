package com.water.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.water.dao.BaseHibernateDAO;
import com.water.dao.HQLConstants;
import com.water.daoi.RegionalDAOI;
import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.City;
import com.water.pojo.District;
import com.water.pojo.State;
import com.water.util.UtilConstants;

public class RegionalDAOImpl extends BaseHibernateDAO implements RegionalDAOI {
	boolean flag = false;
	Session session = null;
	private static final Log log = LogFactory.getLog(RegionalDAOImpl.class);

	public List viewStates() throws ConnectionException, DataNotFoundException {
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_STATES);
			list = queryObject.list();

		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean addState(State state) throws ConnectionException,
			DataNotFoundException {
		try {

			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(state);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public State viewState(State state) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + state.getStateid());
		try {
			State instance = (State) getSession().get(State.class,
					state.getStateid());
			return instance;
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			log.error("get failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}

	}

	public boolean updateState(State state) throws ConnectionException,
			DataNotFoundException {
		log.debug("attaching dirty State instance");
		try {
			System.out.println(state.getStateid());
			System.out.println(state.getStatename());
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			State instance = (State) session.get(State.class, state
					.getStateid());
			instance.setStatename(state.getStatename());
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			System.out.println(re);
			throw re;
		}
		return flag;
	}

	public boolean deleteStates(int stateid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + stateid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			State instance = (State) session.get(State.class, stateid);
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

	public boolean addDistrict(District district) throws ConnectionException,
			DataNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(district);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List viewDistrict(int stateid) throws ConnectionException,
			DataNotFoundException {
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_DISTRICT);
			queryObject.setInteger(0, stateid);
			list = queryObject.list();

		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public District viewDistrictUpdate(int districtid)
			throws ConnectionException, DataNotFoundException {
		log.debug("getting State instance with id: " + districtid);
		try {
			District instance = (District) getSession().get(District.class,
					districtid);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}

	}

	public boolean updateDistrict(District district)
			throws ConnectionException, DataNotFoundException {
		log.debug("attaching dirty State instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			District instance = (District) session.get(District.class, district
					.getDistrictid());
			instance.setDistrictname(district.getDistrictname());
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			System.out.println(re);
			throw re;
		}
		return flag;
	}

	public boolean deleteDistricts(int districtid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + districtid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			District instance = (District) session.get(District.class,
					districtid);
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

	public boolean addCity(City city) throws ConnectionException,
			DataNotFoundException, IOException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			
			File file = new File(city.getImagepath());
			byte[] byteArray = new byte[(int) file.length()];
			Blob blob = Hibernate.createBlob(byteArray);
			
			
			
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(byteArray);
			fileInputStream.close();
			city.setCitymap(blob);
			
			
			
			
			
			
			
			session.save(city);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List viewCities(int stateid, int cityid) throws ConnectionException,
			DataNotFoundException {
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_CITY);
			queryObject.setInteger(0, stateid);
			queryObject.setInteger(1, cityid);
			list = queryObject.list();

		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteCities(int cityid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + cityid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			City instance = (City) session.get(City.class, cityid);
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

	public City viewCityUpdate(int cityid) throws ConnectionException,
			DataNotFoundException, FileNotFoundException, SQLException,
			IOException {
		City city = null;
		try {
			City instance = (City) getSession().get(City.class, cityid);
			return instance;
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
	}

	public boolean updateCity(City city) throws ConnectionException,
			DataNotFoundException, IOException {
		log.debug("attaching dirty State instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			City instance = (City) session.get(City.class, city.getCityid());
			instance.setCityname(city.getCityname());
			instance.setCitydescription(city.getCitydescription());
			
			File file = new File(city.getImagepath());
			byte[] byteArray = new byte[(int) file.length()];
			Blob blob = Hibernate.createBlob(byteArray);
			
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(byteArray);
			fileInputStream.close();

			
			instance.setCitymap(blob);
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			System.out.println(re);
			throw re;
		}
		return flag;
	}
}
