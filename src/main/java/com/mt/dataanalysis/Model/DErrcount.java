package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the d_errcount database table.
 * 
 */
@Entity
@Table(name="d_errcount")
@NamedQuery(name="DErrcount.findAll", query="SELECT d FROM DErrcount d")
public class DErrcount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int codeEnd;

	private int codeStart;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dRecordCreationDate;

	private int groupNO;

	private int index;

	private int pageNum;

	private String temp1;

	private String temp2;

	private int temp3;

	private int temp4;

	private int temp5;

	private int workId;

	public DErrcount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodeEnd() {
		return this.codeEnd;
	}

	public void setCodeEnd(int codeEnd) {
		this.codeEnd = codeEnd;
	}

	public int getCodeStart() {
		return this.codeStart;
	}

	public void setCodeStart(int codeStart) {
		this.codeStart = codeStart;
	}

	public Date getDRecordCreationDate() {
		return this.dRecordCreationDate;
	}

	public void setDRecordCreationDate(Date dRecordCreationDate) {
		this.dRecordCreationDate = dRecordCreationDate;
	}

	public int getGroupNO() {
		return this.groupNO;
	}

	public void setGroupNO(int groupNO) {
		this.groupNO = groupNO;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
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

	public int getWorkId() {
		return this.workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

}