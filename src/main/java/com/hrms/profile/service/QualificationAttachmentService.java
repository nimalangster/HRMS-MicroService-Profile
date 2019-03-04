package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.ProfessionalQualification;
import com.hrms.profile.entity.QualificationAttachment;

public interface QualificationAttachmentService {

	ResponseEntity<?> addQualificationAttachment(QualificationAttachment qualificationAttachment) throws URISyntaxException;
	ResponseEntity<List<QualificationAttachment>> getAllQualificationAttachments();
	ResponseEntity<QualificationAttachment> getQualificationAttachmentById(Integer id);
	void deleteQualificationAttachment(Integer id);
	ResponseEntity<QualificationAttachment> updateQualificationAttachment(QualificationAttachment qualificationAttachment, Integer id) throws URISyntaxException;
	ResponseEntity<List<QualificationAttachment>> searchByUser(Integer userId);
	ResponseEntity<List<QualificationAttachment>> searchByNameAndUser(String name, Integer userId);
	
	
	
	Resource<QualificationAttachment> getQualificationAttachmentResourceById(Integer id);
	Resource<Resource<QualificationAttachment>> getAllQualificationAttachmentResources();
	Resource<Resource<QualificationAttachment>> searchByNameAndUserResources(String name, Integer userId);
	Resource<Resource<QualificationAttachment>> searchByUserResources(Integer userId);
	
}
