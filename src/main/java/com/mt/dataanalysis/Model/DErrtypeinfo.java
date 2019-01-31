package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the d_errtypeinfo database table.
 * 
 */
@Entity
@Table(name="d_errtypeinfo")
@NamedQuery(name="DErrtypeinfo.findAll", query="SELECT d FROM DErrtypeinfo d")
public class DErrtypeinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dRecordCreationDate;

	private String errName;

	private int errType;

	private int productType;

	private String sRecordCreator;

	public DErrtypeinfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDRecordCreationDate() {
		return this.dRecordCreationDate;
	}

	public void setDRecordCreationDate(Date dRecordCreationDate) {
		this.dRecordCreationDate = dRecordCreationDate;
	}

	public String getErrName() {
		return this.errName;
	}

	public void setErrName(String errName) {
		this.errName = errName;
	}

	public int getErrType() {
		return this.errType;
	}

	public void setErrType(int errType) {
		this.errType = errType;
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

}