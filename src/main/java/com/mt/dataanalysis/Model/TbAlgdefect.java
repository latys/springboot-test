package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_algdefect database table.
 * 
 */
@Entity
@Table(name="tb_algdefect")
@NamedQuery(name="TbAlgdefect.findAll", query="SELECT t FROM TbAlgdefect t")
public class TbAlgdefect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="alg_err_description")
	private String algErrDescription;

	@Column(name="alg_err_grade")
	private int algErrGrade;

	@Column(name="alg_err_id")
	private int algErrId;

	@Column(name="alg_region_h")
	private int algRegionH;

	@Column(name="alg_region_id")
	private int algRegionId;

	@Column(name="alg_region_w")
	private int algRegionW;

	@Column(name="alg_region_x")
	private int algRegionX;

	@Column(name="alg_region_y")
	private int algRegionY;

	@Column(name="alg_result_code")
	private int algResultCode;

	private int alg_TrainResultFlag;

	@Column(name="alg_type")
	private int algType;

	@Column(name="id_camera")
	private int idCamera;

	@Column(name="id_pos")
	private int idPos;

	@Column(name="id_product")
	private int idProduct;

	@Column(name="id_trigger")
	private int idTrigger;

	@Column(name="region_data")
	private String regionData;

	@Column(name="region_result")
	private String regionResult;

	public TbAlgdefect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlgErrDescription() {
		return this.algErrDescription;
	}

	public void setAlgErrDescription(String algErrDescription) {
		this.algErrDescription = algErrDescription;
	}

	public int getAlgErrGrade() {
		return this.algErrGrade;
	}

	public void setAlgErrGrade(int algErrGrade) {
		this.algErrGrade = algErrGrade;
	}

	public int getAlgErrId() {
		return this.algErrId;
	}

	public void setAlgErrId(int algErrId) {
		this.algErrId = algErrId;
	}

	public int getAlgRegionH() {
		return this.algRegionH;
	}

	public void setAlgRegionH(int algRegionH) {
		this.algRegionH = algRegionH;
	}

	public int getAlgRegionId() {
		return this.algRegionId;
	}

	public void setAlgRegionId(int algRegionId) {
		this.algRegionId = algRegionId;
	}

	public int getAlgRegionW() {
		return this.algRegionW;
	}

	public void setAlgRegionW(int algRegionW) {
		this.algRegionW = algRegionW;
	}

	public int getAlgRegionX() {
		return this.algRegionX;
	}

	public void setAlgRegionX(int algRegionX) {
		this.algRegionX = algRegionX;
	}

	public int getAlgRegionY() {
		return this.algRegionY;
	}

	public void setAlgRegionY(int algRegionY) {
		this.algRegionY = algRegionY;
	}

	public int getAlgResultCode() {
		return this.algResultCode;
	}

	public void setAlgResultCode(int algResultCode) {
		this.algResultCode = algResultCode;
	}

	public int getAlg_TrainResultFlag() {
		return this.alg_TrainResultFlag;
	}

	public void setAlg_TrainResultFlag(int alg_TrainResultFlag) {
		this.alg_TrainResultFlag = alg_TrainResultFlag;
	}

	public int getAlgType() {
		return this.algType;
	}

	public void setAlgType(int algType) {
		this.algType = algType;
	}

	public int getIdCamera() {
		return this.idCamera;
	}

	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}

	public int getIdPos() {
		return this.idPos;
	}

	public void setIdPos(int idPos) {
		this.idPos = idPos;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdTrigger() {
		return this.idTrigger;
	}

	public void setIdTrigger(int idTrigger) {
		this.idTrigger = idTrigger;
	}

	public String getRegionData() {
		return this.regionData;
	}

	public void setRegionData(String regionData) {
		this.regionData = regionData;
	}

	public String getRegionResult() {
		return this.regionResult;
	}

	public void setRegionResult(String regionResult) {
		this.regionResult = regionResult;
	}

}