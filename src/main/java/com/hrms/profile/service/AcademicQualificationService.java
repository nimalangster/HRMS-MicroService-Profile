package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.User;

public interface AcademicQualificationService {
	
	ResponseEntity<AcademicQualification> addAcademicQualification(AcademicQualification academicQualification) throws URISyntaxException;
	ResponseEntity<List<AcademicQualification>> getAllAcademicQualifications();
	ResponseEntity<AcademicQualification> getAcademicQualificationById(Integer id);
	void deleteAcademicQualification(Integer id);
	ResponseEntity<AcademicQualification> editAcademicQualification(AcademicQualification academicQualification, Integer id) throws URISyntaxException;
	ResponseEntity<List<AcademicQualification>> searchByUser(Integer id);
	
	//For HATEOS enabled clients
	
	ResponseEntity<?> addAcademicQualificationResource(AcademicQualification AcademicQualification) throws URISyntaxException;
	Resources<Resource<AcademicQualification>>  getAllAcademicQualificationResources();
	Resource<AcademicQualification> getAcademicQualificationResourceById(Integer id);	
	ResponseEntity<?> editAcademicQualificationResource(AcademicQualification academicQualification, Integer id) throws URISyntaxException;
	ResponseEntity<List<AcademicQualification>> searchByUserReource(Integer id);
}
