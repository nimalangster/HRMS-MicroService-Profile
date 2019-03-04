package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.ExamType;

public interface ExamTypeService {
	
	ResponseEntity<?> addExamType(ExamType examType) throws URISyntaxException;
	ResponseEntity<List<ExamType>> getAllExamTypes();
	ResponseEntity<ExamType> getExamTypeById(Integer id);
	ResponseEntity<?> deleteExamType(Integer id);
	ResponseEntity<?> editExamType(ExamType examType, Integer id) throws URISyntaxException;
	ResponseEntity<List<ExamType>> searchByName(String name);
	ResponseEntity<List<ExamType>> searchByAcademicQualification(Integer id);
	
	//For HATEOS enabled clients
	
	ResponseEntity<?> addExamTypeResource(ExamType examType) throws URISyntaxException;
	Resources<Resource<ExamType>>  getAllExamTypeResources();
	Resource<ExamType> getExamTypeResourceById(Integer id);	
	ResponseEntity<?> editExamTypeResource(ExamType examType, Integer id) throws URISyntaxException;

}
