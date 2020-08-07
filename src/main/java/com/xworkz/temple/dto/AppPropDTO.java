package com.xworkz.temple.dto;

import org.apache.log4j.Logger;

public class AppPropDTO {

	private int id;
	private String propName;
	private String propValue;
	private String propType;

	private static final Logger logger = Logger.getLogger(AppPropDTO.class);

	public AppPropDTO() {
		logger.info("Invoked App Property Entity Constructer");
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "AppPropDTO [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType=" + propType
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

}
