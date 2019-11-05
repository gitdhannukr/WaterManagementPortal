package com.water.servicei;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.Complaints;
import com.water.pojo.Education;
import com.water.pojo.Enquiry;
import com.water.pojo.Feedback;
import com.water.pojo.TipsSuggestions;
import com.water.pojo.WaterBusiness;

public interface GeneralServiceI {
	public boolean addTipsSuggesition(TipsSuggestions tipsSuggestions)
			throws ConnectionException, DataNotFoundException;

	public Vector<TipsSuggestions> viewTips(int cityid)
			throws ConnectionException, DataNotFoundException;

	public boolean deleteTips(int tipsid) throws ConnectionException,
			DataNotFoundException;

	public boolean addComplaint(Complaints complaints)
			throws ConnectionException, DataNotFoundException;

	public boolean addFeedback(Feedback feedback) throws ConnectionException,
			DataNotFoundException;

	public Vector<Feedback> ViewFeedBacks(int cityid)
			throws ConnectionException, DataNotFoundException;

	public boolean deleteFeedback(int feedbackid) throws ConnectionException,
			DataNotFoundException;

	public boolean addEnquiry(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException;

	public Vector<Enquiry> ViewEnquiry(int cityid) throws ConnectionException,
			DataNotFoundException;

	public boolean deleteEnquiryQuestion(int enquiryid)
			throws ConnectionException, DataNotFoundException;

	public boolean enquryAnswer(Enquiry enquiry) throws ConnectionException,
			DataNotFoundException;

	public boolean addCareerInformation(Education education)
			throws ConnectionException, DataNotFoundException,
			FileNotFoundException, IOException;

	public Vector<Education> viewCareerInfo(String path)
			throws ConnectionException, DataNotFoundException;

	public Vector<Complaints> viewComplaints(int cityid)
			throws ConnectionException, DataNotFoundException;

	public boolean deleteComplaints(int complaintid)
			throws ConnectionException, DataNotFoundException;

	public boolean complaintAnswer(Complaints complaints)
			throws ConnectionException, DataNotFoundException;

	public Vector<WaterBusiness> ViewWaterCostDetails(int parseInt,
			Object attribute);

	public boolean deleteWaterCostDetails(int parseInt)
			throws ConnectionException, DataNotFoundException;

}
