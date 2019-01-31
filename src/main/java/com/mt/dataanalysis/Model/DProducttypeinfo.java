package com.mt.dataanalysis.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the d_producttypeinfo database table.
 * 
 */
@Entity
@Table(name="d_producttypeinfo")
@NamedQuery(name="DProducttypeinfo.findAll", query="SELECT d FROM DProducttypeinfo d")
public class DProducttypeinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dRecordCreationDate;

	private String productcode;

	private String productName;

	private int productType;

	public DProducttypeinfo() {
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

	public String getProductcode() {
		return this.productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductType() {
		return this.productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

}