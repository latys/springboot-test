package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


/**
 * The persistent class for the d_erritemlist database table.
 * 
 */
@Entity
@Table(name="d_erritemlist")
@NamedQuery(name="DErritemlist.findAll", query="SELECT d FROM DErritemlist d")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DErritemlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ct_pic_count")
	private Integer ctPicCount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dRecordCreationDate;

	private String errCode;

	private Integer errCodeNum;

	private Integer errType;

	private String exCode;

	private Integer exCodeNum;

	private Integer groupNo;

	private String guid;

	@Column(name="id_batch")
	private Integer idBatch;

	@Column(name="id_code")
	private String idCode;

	@Column(name="mission_name")
	private String missionName;

	private int pages;

	@Column(name="result_fn_id")
	private Integer resultFnId;

	@Column(name="result_insp_id")
	private Integer resultInspId;

	@Column(name="result_manual_id")
	private Integer resultManualId;

	@Column(name="Static")
	private Integer static_;

	@Column(name="status_code")
	private Integer statusCode;

 
	private String temp1;

	
	private String temp2;

	private Integer temp3;

	private Integer temp4;

	private Integer temp5;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tm_finish")
	private Date tmFinish;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tm_start")
	private Date tmStart;

	private Integer workId;

	public DErritemlist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCtPicCount() {
		return this.ctPicCount;
	}

	public void setCtPicCount(int ctPicCount) {
		this.ctPicCount = ctPicCount;
	}

	public Date getDRecordCreationDate() {
		return this.dRecordCreationDate;
	}

	public void setDRecordCreationDate(Date dRecordCreationDate) {
		this.dRecordCreationDate = dRecordCreationDate;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public int getErrCodeNum() {
		return this.errCodeNum;
	}

	public void setErrCodeNum(int errCodeNum) {
		this.errCodeNum = errCodeNum;
	}

	public int getErrType() {
		return this.errType;
	}

	public void setErrType(int errType) {
		this.errType = errType;
	}

	public String getExCode() {
		return this.exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public int getExCodeNum() {
		return this.exCodeNum;
	}

	public void setExCodeNum(int exCodeNum) {
		this.exCodeNum = exCodeNum;
	}

	public int getGroupNo() {
		return this.groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getIdBatch() {
		return this.idBatch;
	}

	public void setIdBatch(int idBatch) {
		this.idBatch = idBatch;
	}

	public String getIdCode() {
		return this.idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getMissionName() {
		return this.missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getResultFnId() {
		return this.resultFnId;
	}

	public void setResultFnId(int resultFnId) {
		this.resultFnId = resultFnId;
	}

	public int getResultInspId() {
		return this.resultInspId;
	}

	public void setResultInspId(int resultInspId) {
		this.resultInspId = resultInspId;
	}

	public int getResultManualId() {
		return this.resultManualId;
	}

	public void setResultManualId(int resultManualId) {
		this.resultManualId = resultManualId;
	}

	public int getStatic_() {
		return this.static_;
	}

	public void setStatic_(int static_) {
		this.static_ = static_;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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

	public Date getTmFinish() {
		return this.tmFinish;
	}

	public void setTmFinish(Date tmFinish) {
		this.tmFinish = tmFinish;
	}

	public Date getTmStart() {
		return this.tmStart;
	}

	public void setTmStart(Date tmStart) {
		this.tmStart = tmStart;
	}

	public int getWorkId() {
		return this.workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

}