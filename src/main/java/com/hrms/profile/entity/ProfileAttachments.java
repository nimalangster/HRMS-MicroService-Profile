package com.hrms.profile.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="profile_attachments",schema="profile")
public class ProfileAttachments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@ManyToOne()
	private User user;
	
	private byte[] jobApplication;
	private byte[] profilePhoto;
	private byte[] recruitmentSource;
	private byte[] curriculamVitae;
	private byte[] nicCopy;
	private byte[] birthCertificate;
	private byte[] marriageCertificate;
	private byte[] jobOfferLetter;
	private byte[] jobDocs;
	private byte[] agreementsAndContracts;
	private byte[] jobAcknowledgementLetter;
	private byte[] interviewResult;
	private byte[] medicalReport;
	private byte[] salary;
	private byte[] qualifications;
	
	public ProfileAttachments() {
		super();
	}

	public ProfileAttachments(Integer id, byte[] jobApplication, byte[] profilePhoto, byte[] recruitmentSource,
			byte[] curriculamVitae, byte[] nicCopy, byte[] birthCertificate, byte[] marriageCertificate,
			byte[] jobOfferLetter, byte[] jobDocs, byte[] agreementsAndContracts, byte[] jobAcknowledgementLetter,
			byte[] interviewResult, byte[] medicalReport, byte[] salary, byte[] qualifications) {
		super();
		this.id = id;
		this.jobApplication = jobApplication;
		this.profilePhoto = profilePhoto;
		this.recruitmentSource = recruitmentSource;
		this.curriculamVitae = curriculamVitae;
		this.nicCopy = nicCopy;
		this.birthCertificate = birthCertificate;
		this.marriageCertificate = marriageCertificate;
		this.jobOfferLetter = jobOfferLetter;
		this.jobDocs = jobDocs;
		this.agreementsAndContracts = agreementsAndContracts;
		this.jobAcknowledgementLetter = jobAcknowledgementLetter;
		this.interviewResult = interviewResult;
		this.medicalReport = medicalReport;
		this.salary = salary;
		this.qualifications = qualifications;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(byte[] jobApplication) {
		this.jobApplication = jobApplication;
	}

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public byte[] getRecruitmentSource() {
		return recruitmentSource;
	}

	public void setRecruitmentSource(byte[] recruitmentSource) {
		this.recruitmentSource = recruitmentSource;
	}

	public byte[] getCurriculamVitae() {
		return curriculamVitae;
	}

	public void setCurriculamVitae(byte[] curriculamVitae) {
		this.curriculamVitae = curriculamVitae;
	}

	public byte[] getNicCopy() {
		return nicCopy;
	}

	public void setNicCopy(byte[] nicCopy) {
		this.nicCopy = nicCopy;
	}

	public byte[] getBirthCertificate() {
		return birthCertificate;
	}

	public void setBirthCertificate(byte[] birthCertificate) {
		this.birthCertificate = birthCertificate;
	}

	public byte[] getMarriageCertificate() {
		return marriageCertificate;
	}

	public void setMarriageCertificate(byte[] marriageCertificate) {
		this.marriageCertificate = marriageCertificate;
	}

	public byte[] getJobOfferLetter() {
		return jobOfferLetter;
	}

	public void setJobOfferLetter(byte[] jobOfferLetter) {
		this.jobOfferLetter = jobOfferLetter;
	}

	public byte[] getJobDocs() {
		return jobDocs;
	}

	public void setJobDocs(byte[] jobDocs) {
		this.jobDocs = jobDocs;
	}

	public byte[] getAgreementsAndContracts() {
		return agreementsAndContracts;
	}

	public void setAgreementsAndContracts(byte[] agreementsAndContracts) {
		this.agreementsAndContracts = agreementsAndContracts;
	}

	public byte[] getJobAcknowledgementLetter() {
		return jobAcknowledgementLetter;
	}

	public void setJobAcknowledgementLetter(byte[] jobAcknowledgementLetter) {
		this.jobAcknowledgementLetter = jobAcknowledgementLetter;
	}

	public byte[] getInterviewResult() {
		return interviewResult;
	}

	public void setInterviewResult(byte[] interviewResult) {
		this.interviewResult = interviewResult;
	}

	public byte[] getMedicalReport() {
		return medicalReport;
	}

	public void setMedicalReport(byte[] medicalReport) {
		this.medicalReport = medicalReport;
	}

	public byte[] getSalary() {
		return salary;
	}

	public void setSalary(byte[] salary) {
		this.salary = salary;
	}

	public byte[] getQualifications() {
		return qualifications;
	}

	public void setQualifications(byte[] qualifications) {
		this.qualifications = qualifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}