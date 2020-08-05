package com.xworkz.temple.dto;

import org.apache.log4j.Logger;

public class PersonalDTO {

	private static final Logger logger = Logger.getLogger(PersonalDTO.class);

	private int pId;
	private String name;
	private String mobile;
	private String address;
	private String age;
	private String state;
	private String email;

	public PersonalDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "PersonalDTO [pId=" + pId + ", name=" + name + ", mobile=" + mobile + ", address=" + address + ", age="
				+ age + ", state=" + state + ", email=" + email + "]";
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

}
