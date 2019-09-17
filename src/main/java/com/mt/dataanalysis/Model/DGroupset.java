package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the d_groupset database table.
 * 
 */
@Entity
@Table(name="d_groupset")
@NamedQuery(name="DGroupset.findAll", query="SELECT d FROM DGroupset d")
public class DGroupset implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	private int depNum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dRecordCreationDate;

	private String firstCode;

	private int groupNO;

	private String head;

	private Integer pages;

	private String picPath;

	private Integer productType;

	private String sRecordCreator;

	@Column(name="Static")
	private String static_;

	private Integer stopRequery;

	private String temp1;

	private String temp2;

	private Integer temp3;

	private Integer temp4;

	private Integer temp5;

	private Integer useFlag;

	public DGroupset() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getDepNum() {
		return this.depNum;
	}

	public void setDepNum(int depNum) {
		this.depNum = depNum;
	}

	public Date getDRecordCreationDate() {
		return this.dRecordCreationDate;
	}

	public void setDRecordCreationDate(Date dRecordCreationDate) {
		this.dRecordCreationDate = dRecordCreationDate;
	}

	public String getFirstCode() {
		return this.firstCode;
	}

	public void setFirstCode(String firstCode) {
		this.firstCode = firstCode;
	}

	public int getGroupNO() {
		return this.groupNO;
	}

	public void setGroupNO(int groupNO) {
		this.groupNO = groupNO;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public int getProductType() {
		return this.productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getSRecordCreator() {
		return this.sRecordCreator;
	}

	public void setSRecordCreator(String sRecordCreator) {
		this.sRecordCreator = sRecordCreator;
	}

	public String getStatic_() {
		return this.static_;
	}

	public void setStatic_(String static_) {
		this.static_ = static_;
	}

	public int getStopRequery() {
		return this.stopRequery;
	}

	public void setStopRequery(int stopRequery) {
		this.stopRequery = stopRequery;
	}

	public String getTemp1() {
		return this.temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return this.temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public int getTemp3() {
		return this.temp3;
	}

	public void setTemp3(int temp3) {
		this.temp3 = temp3;
	}

	public int getTemp4() {
		return this.temp4;
	}

	public void setTemp4(int temp4) {
		this.temp4 = temp4;
	}

	public int getTemp5() {
		return this.temp5;
	}

	public void setTemp5(int temp5) {
		this.temp5 = temp5;
	}

	public int getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(int useFlag) {
		this.useFlag = useFlag;
	}
	
	@Override
	public String toString() {
		return "DGroupset [id=" + id + ", dateTime=" + dateTime + ", depNum=" + depNum + ", dRecordCreationDate="
				+ dRecordCreationDate + ", firstCode=" + firstCode + ", groupNO=" + groupNO + ", head=" + head
				+ ", pages=" + pages + ", picPath=" + picPath + ", productType=" + productType + ", sRecordCreator="
				+ sRecordCreator + ", static_=" + static_ + ", stopRequery=" + stopRequery + ", temp1=" + temp1
				+ ", temp2=" + temp2 + ", temp3=" + temp3 + ", temp4=" + temp4 + ", temp5=" + temp5 + ", useFlag="
				+ useFlag + "]";
	}


}