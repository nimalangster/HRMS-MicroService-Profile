package com.hrms.profile.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qualification_attachment", schema = "profile")
public class QualificationAttachment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;

	@ManyToOne()
	private User user;

	private String name;
	private byte[] Certificate;

	public QualificationAttachment() {
		super();
	}

	public QualificationAttachment(Integer id, User user, String name, byte[] certificate) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		Certificate = certificate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getCertificate() {
		return Certificate;
	}

	public void setCertificate(byte[] certificate) {
		Certificate = certificate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
