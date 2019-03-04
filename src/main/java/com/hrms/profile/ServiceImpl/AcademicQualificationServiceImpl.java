package com.hrms.profile.ServiceImpl;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.User;
import com.hrms.profile.exceptionhandler.ResourceAlreadyExistsException;
import com.hrms.profile.exceptionhandler.ResourceNotFoundException;
import com.hrms.profile.repository.AcademicQualificationRepository;
import com.hrms.profile.repository.UserRepository;
import com.hrms.profile.service.AcademicQualificationService;

@Service
public class AcademicQualificationServiceImpl implements AcademicQualificationService {

	@Autowired
	AcademicQualificationRepository academicQualificationRepository;
	@Autowired
	UserRepository userRepository;

	
	@Override
	public ResponseEntity<AcademicQualification> addAcademicQualification(AcademicQualification academicQualification)
			throws URISyntaxException {

		Integer id = academicQualification.getId();

		Optional<AcademicQualification> aQFromDB = academicQualificationRepository.findById(id);

		if (aQFromDB.isPresent()) {
			throw new ResourceAlreadyExistsException(id, AcademicQualification.class.getSimpleName());
		}

		AcademicQualification aq = academicQualificationRepository.save(academicQualification);

		return new ResponseEntity<>(aq, HttpStatus.CREATED);
	}

	
	@Override
	public ResponseEntity<List<AcademicQualification>> getAllAcademicQualifications() {
		
		List<AcademicQualification> aQL = academicQualificationRepository.findAll();
		
		if (aQL.isEmpty()) {
			throw new ResourceNotFoundException(null, AcademicQualification.class.getSimpleName());
			//return new ResponseEntity<List<AcademicQualification>>(HttpStatus.NO_CONTENT); 
		}	
		
		return new ResponseEntity<List<AcademicQualification>>(aQL, HttpStatus.FOUND);
				
	}

	
	@Override
	public ResponseEntity<AcademicQualification> getAcademicQualificationById(Integer id) {
		
		AcademicQualification aQ = academicQualificationRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(id, AcademicQualification.class.getSimpleName()));		
		
		return new ResponseEntity<AcademicQualification>(aQ, HttpStatus.FOUND);
	}

	
	@Override
	public void deleteAcademicQualification(Integer id) {

		academicQualificationRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(id, AcademicQualification.class.getSimpleName()));
		
		academicQualificationRepository.deleteById(id);
		
	}

	
	@Override
	public ResponseEntity<AcademicQualification> editAcademicQualification(AcademicQualification academicQualification, Integer id)
			throws URISyntaxException {
		
		Integer aQId = academicQualification.getId();
		
		academicQualificationRepository.findById(aQId)
				.orElseThrow(()-> new ResourceNotFoundException(id, AcademicQualification.class.getSimpleName()));		
		
		AcademicQualification aQ = academicQualificationRepository.save(academicQualification);
		
		return new ResponseEntity<AcademicQualification>(aQ, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<List<AcademicQualification>> searchByUser(Integer id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(id, User.class.getSimpleName()));		
		
		List<AcademicQualification> aQL = academicQualificationRepository.findByUser(user);
		
		if(aQL.isEmpty())
			throw new ResourceNotFoundException(user.getId(), AcademicQualification.class.getSimpleName());
		
		return new ResponseEntity<List<AcademicQualification>>(aQL, HttpStatus.FOUND);
	}

	
	
//  HATEOS AcademicQualification ServiceImple FOR HYPERMEDIA ENABLED CLIENTS.
	
	@Override
	public ResponseEntity<?> addAcademicQualificationResource(AcademicQualification AcademicQualification)
			throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resources<Resource<AcademicQualification>> getAllAcademicQualificationResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<AcademicQualification> getAcademicQualificationResourceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> editAcademicQualificationResource(AcademicQualification academicQualification, Integer id)
			throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<AcademicQualification>> searchByUserReource(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
