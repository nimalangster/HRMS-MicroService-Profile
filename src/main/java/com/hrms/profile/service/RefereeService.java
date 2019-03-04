package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.Referee;

public interface RefereeService {
	
	ResponseEntity<?> addReferee(Referee referee) throws URISyntaxException;
	ResponseEntity<List<Referee>> getAllReferees();
	ResponseEntity<Referee> getRefereeById(Integer id);
	void deleteReferee(Integer id);
	ResponseEntity<Referee> updateReferee(Referee referee, Integer id) throws URISyntaxException;
	ResponseEntity<List<Referee>> searchByName(String name);
	ResponseEntity<List<Referee>> searchByUser(Integer userId);
	
	
	
	Resource<Referee> getRefereeResourceById(Integer id);
	Resource<Resource<Referee>> getAllRefereeResources();
	Resource<Resource<Referee>> searchByNameResources(String name);
	Resource<Resource<Referee>> searchByUserResources(Integer userId);
}
