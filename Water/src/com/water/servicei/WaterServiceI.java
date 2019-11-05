package com.water.servicei;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.WaterBusiness;
import com.water.pojo.WaterInfoPojo;
import com.water.pojo.WaterSupply;

public interface WaterServiceI {
	public boolean addWaterSupplyDetails(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException;

	public Vector<WaterSupply> viewWaterSupplyDetails(int cityid)
			throws ConnectionException, DataNotFoundException;

	public boolean deleteWaterSupplyRecord(int supplyid)
			throws ConnectionException, DataNotFoundException;

	public WaterSupply viewWaterSupplyUpdate(int supplyid)
			throws ConnectionException, DataNotFoundException;

	public boolean updateWaterSupply(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException;

	public boolean addWaterInforamtion(WaterInfoPojo waterInfoPojo)
			throws ConnectionException, DataNotFoundException,
			FileNotFoundException, IOException;

	public Vector<WaterInfoPojo> viewWaterInformation(int cityid, String water,
			String path) throws ConnectionException, DataNotFoundException;

	public boolean deleteWaterInformation(int id) throws ConnectionException,
			DataNotFoundException;

	public boolean addWaterbusinessDetails(WaterBusiness waterBusiness)
			throws ConnectionException;

	public WaterBusiness updateViewWaterCost(int parseInt);

	public boolean updateWaterCostDetails(WaterBusiness waterBusiness);
}
