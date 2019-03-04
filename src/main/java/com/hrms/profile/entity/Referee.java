package com.hrms.profile.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="referee",schema="profile")
public class Referee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2382706104002165442L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne()
	private User user;
	
	private String refereeName;		
	private String Address;
	private String email;	
	private String contactNo;
	private String relationship;	
	
	
	public Referee(Integer id, String refereeName, String address, String email, String contactNo,
			String relationship) {
		super();
		this.id = id;
		this.refereeName = refereeName;
		Address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.relationship = relationship;
	}

	public Referee() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRefereeName() {
		return refereeName;
	}
	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}