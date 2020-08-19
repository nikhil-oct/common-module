package com.xworkz.temple.dto;

import org.apache.log4j.Logger;

public class VisitDTO {

	private static final Logger logger = Logger.getLogger(VisitDTO.class);

	private Integer vId;
	private String specialEntryList;
	private String noOfPersonList;
	private String prasadaList;
	private String idNo;
	private String idList;
	private String date;
	private String poojaTypeList;

	public VisitDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "VisitDTO [vId=" + vId + ", specialEntryList=" + specialEntryList + ", noOfPersonList=" + noOfPersonList
				+ ", prasadaList=" + prasadaList + ", idNo=" + idNo + ", idList=" + idList + ", date=" + date
				+ ", poojaTypeList=" + poojaTypeList + "]";
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getSpecialEntryList() {
		return specialEntryList;
	}

	public void setSpecialEntryList(String specialEntryList) {
		this.specialEntryList = specialEntryList;
	}

	public String getNoOfPersonList() {
		return noOfPersonList;
	}

	public void setNoOfPersonList(String noOfPersonList) {
		this.noOfPersonList = noOfPersonList;
	}

	public String getPrasadaList() {
		return prasadaList;
	}

	public void setPrasadaList(String prasadaList) {
		this.prasadaList = prasadaList;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPoojaTypeList() {
		return poojaTypeList;
	}

	public void setPoojaTypeList(String poojaTypeList) {
		this.poojaTypeList = poojaTypeList;
	}
	
	
	
	
}
