package com.hrms.profile.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.profile.entity.ExamType;
import com.hrms.profile.repository.ExamTypeRepository;
import com.hrms.profile.service.ExamTypeService;

@RestController
@RequestMapping(value = "/examtype")
public class ExamTypeController {
	
	@Autowired
	ExamTypeService examTypeService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ExamType>> getAllExamTypes() {
		
		return examTypeService.getAllExamTypes();
	}
	
	
	@RequestMapping(value = "/{ID}", method = RequestMethod.GET)
	public ResponseEntity<ExamType> getExamTypeById(@PathVariable("id") Integer id) {
		
		return examTypeService.getExamTypeById(id);
	}
	
	
	@RequestMapping(value= "", method = RequestMethod.POST)
	public ResponseEntity<?> addExamType(ExamType examType) throws URISyntaxException {
		
		return examTypeService.addExamType(examType);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<?> editExamType(@RequestBody ExamType examType, @PathVariable("id") Integer id) throws URISyntaxException {
		
		return examTypeService.editExamType(examType, id);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteExamType(@PathVariable("Id") Integer id) {
		
		return examTypeService.deleteExamType(id);
	}
	
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<ExamType>> searchByName(@PathVariable("name") String name) {
		
		return examTypeService.searchByName(name);
	}
	
	
	@RequestMapping(value ="/search/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ExamType>> searchByAcademicQualification(@PathVariable("id") Integer id) {
		
		return examTypeService.searchByAcademicQualification(id);
	}
	
}
