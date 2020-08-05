package com.xworkz.temple.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.xworkz.temple.dto.PersonalDTO;

@Entity
@Table(name = "PERSONAL_INFO")
@NamedQueries({

	@NamedQuery(name = "fetchCountByMobile", query = "select count(*) from PersonalEntity san where mobile=:sanMobile "),
	@NamedQuery(name = "fetchCountByEmailId", query = "select count(*) from PersonalEntity san where email=:sanEmailId ")
		
})

public class PersonalEntity implements Serializable {

	private static final Logger logger = Logger.getLogger(PersonalDTO.class);

	@Id
	@Column(name = "PID")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int pId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "MOBILENO")
	private String mobile;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "AGE")
	private String age;
	@Column(name = "STATE")
	private String state;
	@Column(name = "EMAIL")
	private String email;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "personalEntity")
	private VisitEntity visitEntity;

	public PersonalEntity() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "PersonalEntity [pId=" + pId + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ ", age=" + age + ", state=" + state + ", email=" + email + "]";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public VisitEntity getVisitEntity() {
		return visitEntity;
	}

	public void setVisitEntity(VisitEntity visitEntity) {
		this.visitEntity = visitEntity;
	}

}
