package com.xworkz.temple.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.xworkz.temple.dto.VisitDTO;

@Entity
@Table(name="VISIT_INFO")
public class VisitEntity implements Serializable {
	

	private static final Logger logger = Logger.getLogger(VisitDTO.class);

	@Id
	@Column(name = "VID")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Integer vId;
	@Column(name = "SPECIAL_ENTRANCE")
	private String specialEntryList;
	@Column(name = "NO_OF_PEOPLE")
	private String noOfPersonList;
	@Column(name = "PRASADA")
	private String prasadaList;
	@Column(name = "ID_NO")
	private String idNo;
	@Column(name = "ID_CARD")
	private String idList;
	@Column(name = "DATE")
	private String date;
	@Column(name = "POOJA_TYPE")
	private String poojaTypeList;
	@OneToOne
	@JoinColumn(name="PID")
	private PersonalEntity personalEntity;

	public VisitEntity() {
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

	public PersonalEntity getPersonalEntity() {
		return personalEntity;
	}

	public void setPersonalEntity(PersonalEntity personalEntity) {
		this.personalEntity = personalEntity;
	}
	
	

}
