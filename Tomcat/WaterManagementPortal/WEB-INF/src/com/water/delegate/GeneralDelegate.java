package com.water.delegate;

import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.Complaints;
import com.water.pojo.Education;
import com.water.pojo.Enquiry;
import com.water.pojo.Feedback;
import com.water.pojo.State;
import com.water.pojo.TipsSuggestions;
import com.water.servicei.GeneralServiceI;
import com.water.servicei.impl.GeneralServiceImpl;

public class GeneralDelegate {
	GeneralServiceI generalServiceI = new GeneralServiceImpl();

	public boolean addTipsSuggesition(TipsSuggestions tipsSuggestions)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.addTipsSuggesition(tipsSuggestions);
	}

	public Vector<TipsSuggestions> viewTips(int cityid)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.viewTips(cityid);
	}

	public boolean deleteTips(int tipsid) throws ConnectionException,
			DataNotFoundException {
		return generalServiceI.deleteTips(tipsid);
	}

	public boolean addComplaint(Complaints complaints)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.addComplaint(complaints);
	}

	public boolean addFeedback(Feedback feedback) throws ConnectionException,
			DataNotFoundException {
		return generalServiceI.addFeedback(feedback);
	}

	public Vector<Feedback> ViewFeedBacks(int cityid)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.ViewFeedBacks(cityid);
	}

	public boolean deleteFeedback(int feedbackid) throws ConnectionException,
			DataNotFoundException {
		return generalServiceI.deleteFeedback(feedbackid);
	}

	public boolean addEnquiry(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException {
		return generalServiceI.addEnquiry(enquiry);
	}

	public Vector<Enquiry> ViewEnquiry(int cityid) throws ConnectionException,
			DataNotFoundException {
		return generalServiceI.ViewEnquiry(cityid);
	}

	public boolean deleteEnquiryQuestion(int enquiryid)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.deleteEnquiryQuestion(enquiryid);
	}

	public boolean enquryAnswer(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException {
		return generalServiceI.enquryAnswer(enquiry);
	}

	public boolean addCareerInformation(Education education)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.addCareerInformation(education);
	}

	public Vector<Education> viewCareerInfo(String path)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.viewCareerInfo(path);
	}

	public Vector<Complaints> viewComplaints(int cityid)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.viewComplaints(cityid);
	}

	public boolean deleteComplaints(int complaintid)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.deleteComplaints(complaintid);
	}

	public boolean complaintAnswer(Complaints complaints)
			throws ConnectionException, DataNotFoundException {
		return generalServiceI.complaintAnswer(complaints);
	}

}
