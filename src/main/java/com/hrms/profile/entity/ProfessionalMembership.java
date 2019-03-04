package com.hrms.profile.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="professional_membership",schema="profile")
public class ProfessionalMembership implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1930133425563493625L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne()
	private User user;
	
	private String organizationName;
	private String eventName;
	private String eventType;
	private Integer periodYearFrom;
	private Integer periodYearTo;
	private String award;
	
	public ProfessionalMembership() {
		super();
	}

	public ProfessionalMembership(Integer id, String organizationName, String eventName, String eventType,
			Integer periodYearFrom, Integer periodYearTo, String award) {
		super();
		this.id = id;
		this.organizationName = organizationName;
		this.eventName = eventName;
		this.eventType = eventType;
		this.periodYearFrom = periodYearFrom;
		this.periodYearTo = periodYearTo;
		this.award = award;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Integer getPeriodYearFrom() {
		return periodYearFrom;
	}

	public void setPeriodYearFrom(Integer periodYearFrom) {
		this.periodYearFrom = periodYearFrom;
	}

	public Integer getPeriodYearTo() {
		return periodYearTo;
	}

	public void setPeriodYearTo(Integer periodYearTo) {
		this.periodYearTo = periodYearTo;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
	