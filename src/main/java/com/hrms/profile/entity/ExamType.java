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
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "exam_type", schema = "profile")
public class ExamType implements Serializable {

	private static final long serialVersionUID = 1723391669647580795L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	private String examTypeName;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<AcademicQualification> academicQualification;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	public ExamType() {
		super();
	}

	public List<AcademicQualification> getAcademicQualification() {
		return academicQualification;
	}

	public void setAcademicQualification(List<AcademicQualification> academicQualification) {
		this.academicQualification = academicQualification;
	}

	public ExamType(Integer id, String examTypeName, List<AcademicQualification> academicQualification, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.examTypeName = examTypeName;
		this.academicQualification = academicQualification;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExamTypeName() {
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
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