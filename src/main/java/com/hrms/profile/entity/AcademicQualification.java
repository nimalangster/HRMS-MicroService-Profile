package com.hrms.profile.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "academic_qualification", schema = "profile")
public class AcademicQualification implements Serializable {

	private static final long serialVersionUID = -3461576400367891708L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	@ManyToOne()
	private User user;

	@ManyToMany(mappedBy = "academicQualification", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExamType> examType;

	private Integer periodYearFrom;
	private Integer periodYearTo;
	private String schoolName;
	private String result;
	private Integer examinationYear;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	public AcademicQualification() {
		super();
	}

	

	public AcademicQualification(Integer id, User user, List<ExamType> examType, Integer periodYearFrom,
			Integer periodYearTo, String schoolName, String result, Integer examinationYear, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.examType = examType;
		this.periodYearFrom = periodYearFrom;
		this.periodYearTo = periodYearTo;
		this.schoolName = schoolName;
		this.result = result;
		this.examinationYear = examinationYear;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ExamType> getExamType() {
		return examType;
	}

	public void setExamType(List<ExamType> examType) {
		this.examType = examType;
	}

	public Integer getPeriodYearFrom() {
		return periodYearFrom;
	}

	public void setPeriodYearFrom(Integer periodYearFrom) {
		this.periodYearFrom = periodYearFrom;
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Integer getPeriodYearTo() {
		return periodYearTo;
	}

	public void setPeriodYearTo(Integer periodYearTo) {
		this.periodYearTo = periodYearTo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getExaminationYear() {
		return examinationYear;
	}

	public void setExaminationYear(Integer examinationYear) {
		this.examinationYear = examinationYear;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}