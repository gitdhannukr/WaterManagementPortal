package com.water.servicei.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.Hibernate;

import com.water.daoi.WaterDAOI;
import com.water.daoi.impl.WaterDAOImpl;
import com.water.exception.ConnectionException;
import com.water.exception.DataNotFoundException;
import com.water.pojo.Education;
import com.water.pojo.TipsSuggestions;
import com.water.pojo.WaterBusiness;
import com.water.pojo.WaterInfoPojo;
import com.water.pojo.WaterSupply;
import com.water.servicei.WaterServiceI;

public class WaterServiceImpl implements WaterServiceI {
	WaterDAOI waterDAOI = new WaterDAOImpl();

	public boolean addWaterSupplyDetails(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException {
		return waterDAOI.addWaterSupplyDetails(waterSupply);
	}

	public Vector<WaterSupply> viewWaterSupplyDetails(int cityid)
			throws ConnectionException, DataNotFoundException {
		Vector<WaterSupply> vSupplies = new Vector<WaterSupply>();
		WaterSupply wSupply = null;
		List list = waterDAOI.viewWaterSupplyDetails(cityid);
		for (Iterator it = list.iterator(); it.hasNext();) {
			wSupply = (WaterSupply) it.next();
			vSupplies.add(wSupply);
		}
		return vSupplies;
	}

	public boolean deleteWaterSupplyRecord(int supplyid)
			throws ConnectionException, DataNotFoundException {
		return waterDAOI.deleteWaterSupplyRecord(supplyid);
	}

	public WaterSupply viewWaterSupplyUpdate(int supplyid)
			throws ConnectionException, DataNotFoundException {
		return waterDAOI.viewWaterSupplyUpdate(supplyid);
	}

	public boolean updateWaterSupply(WaterSupply waterSupply)
			throws ConnectionException, DataNotFoundException {
		return waterDAOI.updateWaterSupply(waterSupply);
	}

	public boolean addWaterInforamtion(WaterInfoPojo waterInfoPojo)
			throws ConnectionException, DataNotFoundException, IOException {

		String[] extension = waterInfoPojo.getFilepath().split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			System.out.println(extension[i]);
			waterInfoPojo.setFiletype(extension[i]);
		}

		File file = new File(waterInfoPojo.getFilepath());
		byte[] byteArray = new byte[(int) file.length()];
		Blob blob = Hibernate.createBlob(byteArray);

		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(byteArray);
		fileInputStream.close();

		waterInfoPojo.setFile(blob);
		return waterDAOI.addWaterInforamtion(waterInfoPojo);
	}

	public Vector<WaterInfoPojo> viewWaterInformation(int cityid, String water,
			String path) throws ConnectionException, DataNotFoundException {
		WaterInfoPojo waterInfoPojo;
		Vector<WaterInfoPojo> vWaterInfoPojos = new Vector<WaterInfoPojo>();
		List list = waterDAOI.viewWaterInformation(cityid, water);
		for (Iterator it = list.iterator(); it.hasNext();) {
			String realpath = "";
			waterInfoPojo = (WaterInfoPojo) it.next();
			Blob b;
			try {
				b = waterInfoPojo.getFile();
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "\\" + waterInfoPojo.getId() + "."
						+ waterInfoPojo.getFiletype();
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
			} catch (Exception e) {
				realpath = path + "\\" + waterInfoPojo.getId() + "."
						+ waterInfoPojo.getFiletype();
			}
			waterInfoPojo.setFilepath(realpath);
			vWaterInfoPojos.add(waterInfoPojo);
		}
		return vWaterInfoPojos;

	}

	public boolean deleteWaterInformation(int id) throws ConnectionException,
			DataNotFoundException {
		return waterDAOI.deleteWaterInformation(id);
	}

	public boolean addWaterbusinessDetails(WaterBusiness waterBusiness)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return waterDAOI.addWaterbusinessDetails(waterBusiness);
	}

	public WaterBusiness updateViewWaterCost(int parseInt) {
		// TODO Auto-generated method stub
		WaterBusiness wBusiness = null;
		List list = waterDAOI.updateViewWaterCost(parseInt);
		for (Iterator it = list.iterator(); it.hasNext();) {
			wBusiness = (WaterBusiness) it.next();
		}
		return wBusiness;
	}
	public boolean updateWaterCostDetails(WaterBusiness waterBusiness) {
		// TODO Auto-generated method stub
		return waterDAOI.updateWaterCostDetails(waterBusiness);
	}

}
