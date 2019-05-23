package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the d_erritemlist database table.
 * 
 */
@Entity
@Table(name="d_erritemlist")
@NamedQuery(name="DErritemlist.findAll", query="SELECT d FROM DErritemlist d")
public class DErritemlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "DErritemlist [id=" + id + ", dRecordCreationDate=" + dRecordCreationDate + ", errClass=" + errClass
				+ ", errCode=" + errCode + ", errCodeNum=" + errCodeNum + ", errDep=" + errDep + ", errLocation="
				+ errLocation + ", errType=" + errType + ", exCode=" + exCode + ", exCodeNum=" + exCodeNum
				+ ", groupNo=" + groupNo + ", guid=" + guid + ", imageName=" + imageName + ", pages=" + pages
				+ ", productType=" + productType + ", static_=" + static_ + ", temp1=" + temp1 + ", temp2=" + temp2
				+ ", temp3=" + temp3 + ", temp4=" + temp4 + ", temp5=" + temp5 + ", workId=" + workId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getdRecordCreationDate() {
		return dRecordCreationDate;
	}

	public void setdRecordCreationDate(Date dRecordCreationDate) {
		this.dRecordCreationDate = dRecordCreationDate;
	}

	public Integer getErrClass() {
		return errClass;
	}

	public void setErrClass(Integer errClass) {
		this.errClass = errClass;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public Integer getErrCodeNum() {
		return errCodeNum;
	}

	public void setErrCodeNum(Integer errCodeNum) {
		this.errCodeNum = errCodeNum;
	}

	public Integer getErrDep() {
		return errDep;
	}

	public void setErrDep(Integer errDep) {
		this.errDep = errDep;
	}

	public String getErrLocation() {
		return errLocation;
	}

	public void setErrLocation(String errLocation) {
		this.errLocation = errLocation;
	}

	public Integer getErrType() {
		return errType;
	}

	public void setErrType(Integer errType) {
		this.errType = errType;
	}

	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public Integer getExCodeNum() {
		return exCodeNum;
	}

	public void setExCodeNum(Integer exCodeNum) {
		this.exCodeNum = exCodeNum;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public int getStatic_() {
		return static_;
	}

	public void setStatic_(int static_) {
		this.static_ = static_;
	}

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public Integer getTemp3() {
		return temp3;
	}

	public void setTemp3(Integer temp3) {
		this.temp3 = temp3;
	}

	public Integer getTemp4() {
		return temp4;
	}

	public void setTemp4(Integer temp4) {
		this.temp4 = temp4;
	}

	public Integer getTemp5() {
		return temp5;
	}

	public void setTemp5(Integer temp5) {
		this.temp5 = temp5;
	}

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dRecordCreationDate;

	private Integer errClass;

	private String errCode;

	private Integer errCodeNum;

	private Integer errDep;

	private String errLocation;

	private Integer errType;

	private String exCode;

	private Integer exCodeNum;

	private int groupNo;

	private String guid;

	private String imageName;

	private Integer pages;

	private Integer productType;

	@Column(name="Static")
	private int static_;

	private String temp1;

	private String temp2;

	private Integer temp3;

	private Integer temp4;

	private Integer temp5;

	private Integer workId;

	public DErritemlist() {
	}

	

}