package com.mt.dataanalysis.Model;

public class DErritemDTO {

	String ErrName;
	Integer ErrType;
	String Errlocation;
	String imageName;
	//报错等级
	Integer ErrClass;
	
	public DErritemDTO(String errName, Integer errType, String errlocation, String imageName,Integer errClass) {
		super();
		ErrName = errName;
		ErrType = errType;
		Errlocation = errlocation;
		ErrClass=errClass;
		this.imageName = imageName;
	}
	
	
	public Integer getErrClass() {
		return ErrClass;
	}
	public void setErrClass(Integer errClass) {
		ErrClass = errClass;
	}

	public String getErrName() {
		return ErrName;
	}
	public void setErrName(String errName) {
		ErrName = errName;
	}
	public Integer getErrType() {
		return ErrType;
	}
	public void setErrType(Integer errType) {
		ErrType = errType;
	}
	public String getErrlocation() {
		return Errlocation;
	}
	public void setErrlocation(String errlocation) {
		Errlocation = errlocation;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "DErritemDTO [ErrName=" + ErrName + ", ErrType=" + ErrType + ", Errlocation=" + Errlocation
				+ ", imageName=" + imageName + ", ErrClass="+ErrClass+"]";
	}
	

}
