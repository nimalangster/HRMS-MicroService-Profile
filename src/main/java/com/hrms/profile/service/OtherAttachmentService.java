package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.OtherAttachment;
import com.hrms.profile.entity.User;

public interface OtherAttachmentService {
	
	ResponseEntity<OtherAttachment> addOtherAttachment(OtherAttachment otherAttachment) throws URISyntaxException;
	ResponseEntity<List<OtherAttachment>> getAllOtherAttachments();
	ResponseEntity<OtherAttachment> getOtherAttachmentById(Integer id);
	ResponseEntity<HttpStatus> deleteOtherAttachment(Integer id);
	ResponseEntity<OtherAttachment> editOtherAttachment(OtherAttachment otherAttachment, Integer id) throws URISyntaxException;
	ResponseEntity<List<OtherAttachment>> searchByName(String name);
	ResponseEntity<List<OtherAttachment>> searchByUser(Integer userId);
	
	//For HATEOS enabled clients
	
	ResponseEntity<?> addOtherAttachmentResource(OtherAttachment otherAttachment) throws URISyntaxException;
	Resources<Resource<OtherAttachment>>  getAllOtherAttachmentResources();
	Resource<OtherAttachment> getOtherAttachmentResourceById(Integer id);	
	ResponseEntity<?> editOtherAttachmentResource(OtherAttachment otherAttachment, Integer id) throws URISyntaxException;

}
