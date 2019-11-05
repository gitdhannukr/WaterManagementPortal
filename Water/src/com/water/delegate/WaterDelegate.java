package com.water.delegate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.TipsSuggestions;
import com.water.pojo.WaterBusiness;
import com.water.pojo.WaterInfoPojo;
import com.water.pojo.WaterSupply;
import com.water.servicei.GeneralServiceI;
import com.water.servicei.WaterServiceI;
import com.water.servicei.impl.GeneralServiceImpl;
import com.water.servicei.impl.WaterServiceImpl;

public class WaterDelegate {
	WaterServiceI waterServiceI = new WaterServiceImpl();

	public boolean addWaterSupplyDetails(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException {
		return waterServiceI.addWaterSupplyDetails(waterSupply);
	}

	public Vector<WaterSupply> viewWaterSupplyDetails(int cityid)
			throws ConnectionException, DataNotFoundException {
		return waterServiceI.viewWaterSupplyDetails(cityid);
	}

	public boolean deleteWaterSupplyRecord(int supplyid)
			throws ConnectionException, DataNotFoundException {
		return waterServiceI.deleteWaterSupplyRecord(supplyid);
	}

	public WaterSupply viewWaterSupplyUpdate(int supplyid)
			throws ConnectionException, DataNotFoundException {
		return waterServiceI.viewWaterSupplyUpdate(supplyid);
	}

	public boolean updateWaterSupply(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException {
		return waterServiceI.updateWaterSupply(waterSupply);
	}

	public boolean addWaterInforamtion(WaterInfoPojo waterInfoPojo)
			throws ConnectionException, DataNotFoundException, IOException {
		return waterServiceI.addWaterInforamtion(waterInfoPojo);
	}

	public Vector<WaterInfoPojo> viewWaterInformation(int cityid, String water,
			String path) throws ConnectionException, DataNotFoundException {
		return waterServiceI.viewWaterInformation(cityid, water, path);
	}

	public boolean deleteWaterInformation(int id) throws ConnectionException,
			DataNotFoundException {
		return waterServiceI.deleteWaterInformation(id);
	}

	public boolean addWaterbusinessDetails(WaterBusiness waterBusiness)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return waterServiceI.addWaterbusinessDetails(waterBusiness);
	}

	public WaterBusiness updateViewWaterCost(int parseInt) {
		// TODO Auto-generated method stub
		return waterServiceI.updateViewWaterCost(parseInt);
	}

	public boolean updateWaterCostDetails(WaterBusiness waterBusiness) {
		// TODO Auto-generated method stub
		return waterServiceI.updateWaterCostDetails(waterBusiness);
	}

}
