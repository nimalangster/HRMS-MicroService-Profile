package com.hrms.profile.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="work_experience",schema="profile")
public class WorkExperience implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5562561549450734893L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;	
	
	@ManyToOne()
	private User user;
	
	private String companyName;
	private String workPlace;
	private Integer periodYearFrom;
	private Integer periodYearTo;
	private String designation;
	private String workType;
	private String reasonForLeaving;
	private Integer leavingSalary;
	
	public WorkExperience() {
		super();
	}

	public WorkExperience(Integer id, String companyName, String workPlace, Integer periodYearFrom,
			Integer periodYearTo, String designation, String workType, String reasonForLeaving, Integer leavingSalary) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.workPlace = workPlace;
		this.periodYearFrom = periodYearFrom;
		this.periodYearTo = periodYearTo;
		this.designation = designation;
		this.workType = workType;
		this.reasonForLeaving = reasonForLeaving;
		this.leavingSalary = leavingSalary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getReasonForLeaving() {
		return reasonForLeaving;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		this.reasonForLeaving = reasonForLeaving;
	}

	public Integer getLeavingSalary() {
		return leavingSalary;
	}

	public void setLeavingSalary(Integer leavingSalary) {
		this.leavingSalary = leavingSalary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}