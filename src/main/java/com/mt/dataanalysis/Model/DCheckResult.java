package com.mt.dataanalysis.Model;

public class DCheckResult {

	@Override
	public String toString() {
		return "DCheckResult [batchno=" + batchno + ", totalCount=" + totalCount + ", errCount=" + errCount + ", startCode=" + startCode + "]";
	}
	private String batchno;
	private Integer totalCount;
	private Integer errCount;
	private String  startCode;

	public String getStartCode() {
		return startCode;
	}
	public void setStartCode(String startcode) {
		this.startCode = startcode;
	}
	
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getErrCount() {
		return errCount;
	}
	public void setErrCount(Integer errCount) {
		this.errCount = errCount;
	}

}
