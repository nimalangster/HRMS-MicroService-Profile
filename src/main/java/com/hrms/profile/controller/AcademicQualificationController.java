package com.hrms.profile.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.service.AcademicQualificationService;

@RestController
@RequestMapping(value = "/academicqualification")
public class AcademicQualificationController {
	
	@Autowired
	AcademicQualificationService academicQualificationService;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)	
	public ResponseEntity<List<AcademicQualification>> getAllAcademicQualifications(){
		
		return academicQualificationService.getAllAcademicQualifications();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AcademicQualification> getAcademicQualificationById(@PathVariable("id") Integer id){
		
		return academicQualificationService.getAcademicQualificationById(id);
	}
	

	@RequestMapping( value = "", method = RequestMethod.POST)
	public ResponseEntity<AcademicQualification> addAcademicQualification(@RequestBody AcademicQualification aQ) throws URISyntaxException{
				
		return academicQualificationService.addAcademicQualification(aQ);			
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<AcademicQualification> updateAcademicQualification(@RequestBody AcademicQualification aQ, Integer id) throws URISyntaxException{
		
		return academicQualificationService.editAcademicQualification(aQ, id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAcademicQualification(@PathVariable("id") Integer id){
		
		academicQualificationService.deleteAcademicQualification(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	public ResponseEntity<List<AcademicQualification>> searchByUser(@PathVariable("id") Integer id){
		
		return academicQualificationService.searchByUser(id);
	}
	
	
	
}