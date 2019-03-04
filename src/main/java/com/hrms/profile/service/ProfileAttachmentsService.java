package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.ProfileAttachments;

public interface ProfileAttachmentsService{

	ResponseEntity<?> addProfileAttachments(ProfileAttachments profileAttachments) throws URISyntaxException;
	ResponseEntity<List<ProfileAttachments>> getAllProfileAttachments();
	ResponseEntity<ProfileAttachments> getProfileAttachmentById(Integer id);
	void deleteProfileAttachment(Integer id);
	ResponseEntity<ProfileAttachments> updateProfileAttachment(ProfileAttachments profileAttachments, Integer id) throws URISyntaxException;
	ResponseEntity<List<ProfileAttachments>> searchByUser(Integer userId);		
	
	
	Resource<ProfileAttachments> getProfileAttachmentResourceById(Integer id);
	Resource<Resource<ProfileAttachments>> getAllProfileAttachmentsResources();
	Resource<Resource<ProfileAttachments>> searchByUserResources(Integer userId);
	
}
