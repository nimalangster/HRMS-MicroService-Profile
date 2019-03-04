package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.ProfessionalQualification;

public interface ProfessionalQualificationService {
	
	ResponseEntity<?> addProfessionalQualification(ProfessionalQualification professionalQualification) throws URISyntaxException;
	ResponseEntity<List<ProfessionalQualification>> getAllProfessionalQualifications();
	ResponseEntity<ProfessionalQualification> getProfessionalQualificationById(Integer id);
	void deleteProfessionalQualification(Integer id);
	ResponseEntity<ProfessionalQualification> updateProfessionalQualification(ProfessionalQualification professionalQualification, Integer id) throws URISyntaxException;
	ResponseEntity<List<ProfessionalQualification>> searchByCourseName(String courseName);
	ResponseEntity<List<ProfessionalQualification>> searchByUser(Integer userId);
	
	
	
	Resource<ProfessionalQualification> getProfessionalQualificationResourceById(Integer id);
	Resource<Resource<ProfessionalQualification>> getAllProfessionalQualificationResources();
	Resource<Resource<ProfessionalQualification>> searchByCourseNameResources(String courseName);
	Resource<Resource<ProfessionalQualification>> searchByUserResources(Integer userId);
}
