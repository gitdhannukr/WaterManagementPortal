package com.water.daoi;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.WaterBusiness;
import com.water.pojo.WaterInfoPojo;
import com.water.pojo.WaterSupply;

public interface WaterDAOI {
	public boolean addWaterSupplyDetails(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException;

	public List viewWaterSupplyDetails(int cityid) throws ConnectionException,
			DataNotFoundException;

	public boolean deleteWaterSupplyRecord(int supplyid)
			throws ConnectionException, DataNotFoundException;

	public WaterSupply viewWaterSupplyUpdate(int supplyid)
			throws ConnectionException, DataNotFoundException;

	public boolean updateWaterSupply(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException;

	public boolean addWaterInforamtion(WaterInfoPojo waterInfoPojo)
			throws ConnectionException, DataNotFoundException,
			FileNotFoundException;

	public List viewWaterInformation(int cityid, String water)
			throws ConnectionException, DataNotFoundException;

	public boolean deleteWaterInformation(int id) throws ConnectionException,
			DataNotFoundException;

	public boolean addWaterbusinessDetails(WaterBusiness waterBusiness)
			throws ConnectionException;

	public List updateViewWaterCost(int parseInt);

	public boolean updateWaterCostDetails(WaterBusiness waterBusiness);

}
