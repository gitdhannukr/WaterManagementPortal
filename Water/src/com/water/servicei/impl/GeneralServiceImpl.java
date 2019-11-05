package com.water.servicei.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.water.daoi.GeneralDAOI;
import com.water.daoi.impl.GeneralDAOImpl;
import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.City;
import com.water.pojo.Complaints;
import com.water.pojo.Education;
import com.water.pojo.Enquiry;
import com.water.pojo.Feedback;
import com.water.pojo.State;
import com.water.pojo.TipsSuggestions;
import com.water.pojo.WaterBusiness;
import com.water.servicei.GeneralServiceI;

public class GeneralServiceImpl implements GeneralServiceI {

	GeneralDAOI generalDAOI = new GeneralDAOImpl();

	public boolean addTipsSuggesition(TipsSuggestions tipsSuggestions)
			throws ConnectionException, DataNotFoundException {
		return generalDAOI.addTipsSuggesition(tipsSuggestions);
	}

	public Vector<TipsSuggestions> viewTips(int cityid)
			throws ConnectionException, DataNotFoundException {
		Vector<TipsSuggestions> vSuggestions = new Vector<TipsSuggestions>();
		TipsSuggestions tipsSuggestions = null;
		List list = generalDAOI.viewTips(cityid);
		for (Iterator it = list.iterator(); it.hasNext();) {
			tipsSuggestions = (TipsSuggestions) it.next();
			vSuggestions.add(tipsSuggestions);
		}

		return vSuggestions;
	}

	public boolean deleteTips(int tipsid) throws ConnectionException,
			DataNotFoundException {
		return generalDAOI.deleteTips(tipsid);
	}

	public boolean addComplaint(Complaints complaints)
			throws ConnectionException, DataNotFoundException {
		return generalDAOI.addComplaint(complaints);
	}

	public boolean addFeedback(Feedback feedback) throws ConnectionException,
			DataNotFoundException {
		return generalDAOI.addFeedback(feedback);
	}

	public Vector<Feedback> ViewFeedBacks(int cityid)
			throws ConnectionException, DataNotFoundException {
		List list = generalDAOI.ViewFeedBacks(cityid);
		Vector<Feedback> vFeedbacks = new Vector<Feedback>();
		Feedback feedback = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			feedback = (Feedback) it.next();
			vFeedbacks.add(feedback);
		}

		return vFeedbacks;
	}

	public boolean deleteFeedback(int feedbackid) throws ConnectionException,
			DataNotFoundException {
		return generalDAOI.deleteFeedback(feedbackid);
	}

	public boolean addEnquiry(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException {
		return generalDAOI.addEnquiry(enquiry);
	}

	public Vector<Enquiry> ViewEnquiry(int cityid) throws ConnectionException,
			DataNotFoundException {
		List list = generalDAOI.ViewEnquiry(cityid);
		Vector<Enquiry> vEnquiries = new Vector<Enquiry>();
		Enquiry enquiry = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			enquiry = (Enquiry) it.next();
			vEnquiries.add(enquiry);
		}
		return vEnquiries;
	}

	public boolean deleteEnquiryQuestion(int enquiryid)
			throws ConnectionException, DataNotFoundException {
		return generalDAOI.deleteEnquiryQuestion(enquiryid);
	}

	public boolean enquryAnswer(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException {
		return generalDAOI.enquryAnswer(enquiry);
	}

	public boolean addCareerInformation(Education education)
			throws ConnectionException, DataNotFoundException,
			FileNotFoundException, IOException {
		return generalDAOI.addCareerInformation(education);
	}

	public Vector<Education> viewCareerInfo(String path)
			throws ConnectionException, DataNotFoundException {
		Education education = null;
		Vector<Education> vEducations = new Vector<Education>();
		List list = generalDAOI.viewCareerInfo(path);
		for (Iterator it = list.iterator(); it.hasNext();) {
			String realpath = "";
			education = (Education) it.next();
			Blob b;
			try {
				b = education.getEducationdoc();
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "\\" + education.getEducationid() + ".pdf";

				System.out.println("realpath---->:" + realpath);
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
			} catch (Exception e) {
				realpath = path + "\\" + education.getEducationid() + ".pdf";
			}
			education.setEducationdocumentaion(realpath);
			vEducations.add(education);
		}
		return vEducations;
	}

	public Vector<Complaints> viewComplaints(int cityid)
			throws ConnectionException, DataNotFoundException {
		List list = generalDAOI.viewComplaints(cityid);
		Vector<Complaints> vComplaints = new Vector<Complaints>();
		Complaints complaints = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			complaints = (Complaints) it.next();
			vComplaints.add(complaints);
		}
		return vComplaints;
	}

	public boolean deleteComplaints(int complaintid)
			throws ConnectionException, DataNotFoundException {
		return generalDAOI.deleteComplaints(complaintid);
	}

	public boolean complaintAnswer(Complaints complaints)
			throws ConnectionException, DataNotFoundException {
		return generalDAOI.complaintAnswer(complaints);
	}

	public Vector<WaterBusiness> ViewWaterCostDetails(int parseInt,
			Object attribute) {
		List list = generalDAOI.ViewWaterCostDetails(parseInt, attribute);
		Vector<WaterBusiness> vWaterBusinesses = new Vector<WaterBusiness>();
		WaterBusiness waterBusiness = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			waterBusiness = (WaterBusiness) it.next();
			vWaterBusinesses.add(waterBusiness);
		}
		return vWaterBusinesses;
	}

	public boolean deleteWaterCostDetails(int parseInt)
			throws ConnectionException, DataNotFoundException {
		// TODO Auto-generated method stub
		return generalDAOI.deleteWaterCostDetails(parseInt);
	}
}
