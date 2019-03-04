package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.ProfessionalMembership;

public interface ProfessionalMembershipService {
	
	ResponseEntity<?> addProfessionalMembership(ProfessionalMembership professionalMembership) throws URISyntaxException;
	ResponseEntity<List<ProfessionalMembership>> getAllProfessionalMemberships();
	ResponseEntity<ProfessionalMembership> getProfessionalMembershipById(Integer id);
	void deleteProfessionalMembership(Integer id);
	ResponseEntity<?> editProfessionalMembership(ProfessionalMembership professionalMembership, Integer id) throws URISyntaxException;
	ResponseEntity<List<ProfessionalMembership>> searchByName(String name);
	
	//For HATEOS enabled clients
	
	ResponseEntity<?> addProfessionalMembershipResource(ProfessionalMembership professionalMembership) throws URISyntaxException;
	Resources<Resource<ProfessionalMembership>>  getAllProfessionalMembershipResources();
	Resource<ProfessionalMembership> getProfessionalMembershipResourceById(Integer id);	
	ResponseEntity<?> editProfessionalMembershipResource(ProfessionalMembership professionalMembership, Integer id) throws URISyntaxException;

}
