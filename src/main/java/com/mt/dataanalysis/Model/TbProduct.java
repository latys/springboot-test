package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_product database table.
 * 
 */
@Entity
@Table(name="tb_product")
@NamedQuery(name="TbProduct.findAll", query="SELECT t FROM TbProduct t")
public class TbProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ct_pic_count")
	private int ctPicCount;

	private String guid;

	@Column(name="id_batch")
	private int idBatch;

	@Column(name="id_code")
	private String idCode;

	@Column(name="mission_name")
	private String missionName;

	@Column(name="result_fn_id")
	private int resultFnId;

	@Column(name="result_insp_id")
	private int resultInspId;

	@Column(name="result_manual_id")
	private int resultManualId;

	@Column(name="status_code")
	private int statusCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tm_finish")
	private Date tmFinish;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tm_start")
	private Date tmStart;

	public TbProduct() {
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

	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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

}