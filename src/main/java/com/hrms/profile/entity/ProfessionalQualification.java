package com.hrms.profile.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professional_qualification", schema = "profile")
public class ProfessionalQualification implements Serializable {

	private static final long serialVersionUID = -783618122291051997L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private User user;

	private String courseName;
	private String courseType;
	private Integer periodYearFrom;
	private Integer periodYearTo;
	private Integer examinationYear;
	private String instituteName;
	private String result;
	private Float gpa;

	public ProfessionalQualification() {
		super();
	}

	public ProfessionalQualification(Integer id, String courseName, String courseType, Integer periodYearFrom,
			Integer periodYearTo, Integer examinationYear, String instituteName, String result, Float gpa, User user) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseType = courseType;
		this.periodYearFrom = periodYearFrom;
		this.periodYearTo = periodYearTo;
		this.examinationYear = examinationYear;
		this.instituteName = instituteName;
		this.result = result;
		this.gpa = gpa;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
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

	public Integer getExaminationYear() {
		return examinationYear;
	}

	public void setExaminationYear(Integer examinationYear) {
		this.examinationYear = examinationYear;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Float getGpa() {
		return gpa;
	}

	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}