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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

	@Component
	@Entity
	@Table(name = "user", schema = "profile")
	public class User implements Serializable {
	 
	  private static final long serialVersionUID = 8918656601415434315L;
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @ApiModelProperty(notes = "The database generated user id of the user")
	  private Integer id;
	  
	  @ApiModelProperty(notes = "The full name of the user")
	  private String fullName;	
	  
	  @ApiModelProperty(notes = "The appointment id of the user to connect appointment micro service")
	  private Integer appointmentId;
	  private String gender;
	  private String telephoneNumber;
	  private String mobileNumber;
	  private String email;
	  private String permenentAddress;
	  private Date joinDate;
	  private Integer servicePeriod;
	  private String profilePhoto;
	  private String nationality;
	  private String nic;
	  private String religion;
	  private Date dateOfBirth;
	  
	  @ApiModelProperty(notes = "The residential address of the user")
	  private String residentialAddress;
	  private String maritalStatus;
	  
	  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	  private List<ProfessionalQualification> professionalQualifications;
	  
	  @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
	  private List<AcademicQualification> academicQualifications;
	  
	  @OneToMany(mappedBy = "user",  cascade = {CascadeType.ALL})
	  private List<WorkExperience> workExperiences;
	  
	  @OneToMany(mappedBy = "user",  cascade = {CascadeType.ALL})
	  private List<ProfessionalMembership> professionalMemberships;
	  
	  @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
	  private List<ProfileAttachments> profileAttachments;
	  
	  @OneToMany(mappedBy = "user",  cascade = {CascadeType.ALL})
	  private List<Referee> referees;
	  
	  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	  private List<OtherAttachment> otherAttachments;
	  
	  private Integer departmentId;

	  @UpdateTimestamp
	  private Date updateAt;
	  
	  @CreationTimestamp
	  private Date createdAt;
	  

	public User(Integer id, String fullName, Integer appointmentId, String gender, String telephoneNumber,
			String mobileNumber, String email, String permenentAddress, Date joinDate, Integer servicePeriod,
			String profilePhoto, String nationality, String nic, String religion, Date dateOfBirth,
			String residentialAddress, String maritalStatus, List<ProfessionalQualification> professionalQualifications,
			List<AcademicQualification> academicQualifications, List<WorkExperience> workExperiences,
			List<ProfessionalMembership> professionalMemberships, List<ProfileAttachments> profileAttachments,
			List<Referee> referees, Integer departmentId, Date updateAt, Date createdAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.appointmentId = appointmentId;
		this.gender = gender;
		this.telephoneNumber = telephoneNumber;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.permenentAddress = permenentAddress;
		this.joinDate = joinDate;
		this.servicePeriod = servicePeriod;
		this.profilePhoto = profilePhoto;
		this.nationality = nationality;
		this.nic = nic;
		this.religion = religion;
		this.dateOfBirth = dateOfBirth;
		this.residentialAddress = residentialAddress;
		this.maritalStatus = maritalStatus;
		this.professionalQualifications = professionalQualifications;
		this.academicQualifications = academicQualifications;
		this.workExperiences = workExperiences;
		this.professionalMemberships = professionalMemberships;
		this.profileAttachments = profileAttachments;
		this.referees = referees;
		this.departmentId = departmentId;
		this.updateAt = updateAt;
		this.createdAt = createdAt;
	}


	public User() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermenentAddress() {
		return permenentAddress;
	}

	public void setPermenentAddress(String permenentAddress) {
		this.permenentAddress = permenentAddress;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(Integer servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	
	
	public List<ProfessionalQualification> getProfessionalQualifications() {
		return professionalQualifications;
	}


	public void setProfessionalQualifications(List<ProfessionalQualification> professionalQualifications) {
		this.professionalQualifications = professionalQualifications;
	}


	public List<AcademicQualification> getAcademicQualifications() {
		return academicQualifications;
	}


	public void setAcademicQualifications(List<AcademicQualification> academicQualifications) {
		this.academicQualifications = academicQualifications;
	}


	public List<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}


	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}


	public List<ProfessionalMembership> getProfessionalMemberships() {
		return professionalMemberships;
	}


	public void setProfessionalMemberships(List<ProfessionalMembership> professionalMemberships) {
		this.professionalMemberships = professionalMemberships;
	}


	public List<ProfileAttachments> getProfileAttachments() {
		return profileAttachments;
	}


	public void setProfileAttachments(List<ProfileAttachments> profileAttachments) {
		this.profileAttachments = profileAttachments;
	}


	public List<Referee> getReferees() {
		return referees;
	}


	public void setReferees(List<Referee> referees) {
		this.referees = referees;
	}


	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}  	  
	  
	}
