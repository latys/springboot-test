package com.mt.dataanalysis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class MTPConf {

	@Value("${MTPY.MachineNO}")     private int machineNo;
	@Value("${MTPY.MachineName}")     private String machineName;
	@Value("${MTPY.productType}")     private String productType;
	@Value("${MTPY.productName}")     private String productName;
	@Value("${MTPY.firstGZPos}")     private int firstGZPos;
	@Value("${MTPY.secondGZPos}")     private int secondGZPos;

	@Value("${MTPY.workstationCount}")     private int workstationCount;
	
	public int getMachineNo() {
		return machineNo;
	}
	public void setMachineNo(int machineNo) {
		this.machineNo = machineNo;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getFirstGZPos() {
		return firstGZPos;
	}
	public void setFirstGZPos(int firstGZPos) {
		this.firstGZPos = firstGZPos;
	}
	public int getSecondGZPos() {
		return secondGZPos;
	}
	public void setSecondGZPos(int secondGZPos) {
		this.secondGZPos = secondGZPos;
	}
	public int getWorkstationCount() {
		return workstationCount;
	}
	public void setWorkstationCount(int workstationCount) {
		this.workstationCount = workstationCount;
	}


}
