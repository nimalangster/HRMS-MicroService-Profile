package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.WorkExperience;

public interface WorkExperienceService {
	
	ResponseEntity<?> addWorkExperience(WorkExperience workExperience) throws URISyntaxException;
	ResponseEntity<List<WorkExperience>> getAllWorkExperiences();
	ResponseEntity<WorkExperience> getWorkExperienceById(Integer id);
	void deleteWorkExperience(Integer id);
	ResponseEntity<WorkExperience> updateWorkExperience(WorkExperience workExperience, Integer id) throws URISyntaxException;	
	ResponseEntity<List<WorkExperience>> searchByUser(Integer userId);
	
	
	
	Resource<WorkExperience> getWorkExperienceResourceById(Integer id);
	Resource<Resource<WorkExperience>> getAllWorkExperienceResources();	
	Resource<Resource<WorkExperience>> searchByUserResources(Integer userId);

}
