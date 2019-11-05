package com.water.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.water.dao.BaseHibernateDAO;
import com.water.dao.HQLConstants;
import com.water.daoi.GeneralDAOI;
import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.Complaints;
import com.water.pojo.Education;
import com.water.pojo.Enquiry;
import com.water.pojo.Feedback;
import com.water.pojo.TipsSuggestions;
import com.water.pojo.WaterBusiness;
import com.water.util.UtilConstants;

public class GeneralDAOImpl extends BaseHibernateDAO implements GeneralDAOI {
	boolean flag = false;
	Session session = null;
	private static final Log log = LogFactory.getLog(RegionalDAOImpl.class);

	public boolean addTipsSuggesition(TipsSuggestions tipsSuggestions)
			throws ConnectionException, DataNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(tipsSuggestions);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List viewTips(int cityid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + cityid);
		System.out.println(cityid);
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_TIPS);
			queryObject.setInteger(0, cityid);
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteTips(int tipsid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + tipsid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			TipsSuggestions instance = (TipsSuggestions) session.get(
					TipsSuggestions.class, tipsid);
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

	public boolean addComplaint(Complaints complaints)
			throws ConnectionException, DataNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			complaints.setComplaintstatusstatus("Pending");
			session.save(complaints);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public boolean addFeedback(Feedback feedback) throws ConnectionException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(feedback);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List ViewFeedBacks(int cityid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting FeedBack instance with id: " + cityid);
		System.out.println(cityid);
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_FEEDBACK);
			queryObject.setInteger(0, cityid);
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteFeedback(int feedbackid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting State instance with id: " + feedbackid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Feedback instance = (Feedback) session.get(Feedback.class,
					feedbackid);
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

	public boolean addEnquiry(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(enquiry);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List ViewEnquiry(int cityid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting Enquiry instance with id: " + cityid);
		System.out.println(cityid);
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_ENQUIRY);
			queryObject.setInteger(0, cityid);
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteEnquiryQuestion(int enquiryid)
			throws ConnectionException, DataNotFoundException {
		log.debug("getting Enquiry instance with id: " + enquiryid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Enquiry instance = (Enquiry) session.get(Enquiry.class, enquiryid);
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

	public boolean enquryAnswer(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException {
		log.debug("attaching dirty State instance");
		try {
			Session session = getSession();
			System.out.println(enquiry.getEnquiryid());
			Transaction transaction = session.beginTransaction();
			Enquiry instance = (Enquiry) session.get(Enquiry.class, enquiry
					.getEnquiryid());
			instance.setEnquiryreply(enquiry.getEnquiryreply());
			instance.setEnquirystatus(enquiry.getEnquirystatus());
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

	public boolean addCareerInformation(Education education)
			throws ConnectionException, DataNotFoundException, IOException {
		try {
			System.out.println("ahiii");
			Session session = getSession();
			System.out.println(education.getEducationdocumentaion());
			Transaction transaction = session.beginTransaction();
			File file = new File(education.getEducationdocumentaion());
			byte[] byteArray = new byte[(int) file.length()];
			Blob blob = Hibernate.createBlob(byteArray);
			education.setEducationdoc(blob);

			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(byteArray);
			fileInputStream.close();

			session.save(education);
			transaction.commit();
			flag = true;
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return flag;
	}

	public List viewCareerInfo(String path) throws ConnectionException,
			DataNotFoundException {
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_EDUCATION);

			return queryObject.list();

		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}

	}

	public List viewComplaints(int cityid) throws ConnectionException,
			DataNotFoundException {
		log.debug("getting Enquiry Complaints with id: " + cityid);
		System.out.println(cityid);
		List list;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._VIEW_COMPLAINTS);
			queryObject.setInteger(0, cityid);
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);
			throw new ConnectionException(UtilConstants._TECH_PROBLEM);
		}
		return list;
	}

	public boolean deleteComplaints(int complaintid)
			throws ConnectionException, DataNotFoundException {
		log.debug("getting Complaint instance with id: " + complaintid);
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Complaints complaints = (Complaints) session.get(Complaints.class,
					complaintid);
			session.delete(complaints);
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

	public boolean complaintAnswer(Complaints complaints)
			throws ConnectionException, DataNotFoundException {
		log.debug("attaching dirty State instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Complaints instance = (Complaints) session.get(Complaints.class,
					complaints.getComplaintid());
			instance.setComplaintsolution(complaints.getComplaintsolution());
			instance.setComplaintstatusstatus(complaints
					.getComplaintstatusstatus());
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

	public List ViewWaterCostDetails(int parseInt, Object attribute) {
		log.debug("getting Enquiry Complaints with id: " + parseInt);
		List list = null;
		try {
			Query queryObject = getSession().createQuery(
					HQLConstants._WATER_COST);
			System.out.println(parseInt);
			System.out.println(attribute.toString());
			queryObject.setInteger(0, parseInt);
			queryObject.setString(1, attribute.toString());
			list = queryObject.list();
		} catch (RuntimeException re) {
			System.err.println(re);
			log.error("find all failed", re);

		}
		return list;
	}

	public boolean deleteWaterCostDetails(int parseInt)
			throws ConnectionException, DataNotFoundException {
		try {
			System.out.println(parseInt);
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			WaterBusiness waterBusiness = (WaterBusiness) session.get(
					WaterBusiness.class, parseInt);
			session.delete(waterBusiness);
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
