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
import org.springframework.web.bind.annotation.RequestBody;

import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.ExamType;
import com.hrms.profile.exceptionhandler.ResourceAlreadyExistsException;
import com.hrms.profile.exceptionhandler.ResourceNotFoundException;
import com.hrms.profile.repository.AcademicQualificationRepository;
import com.hrms.profile.repository.ExamTypeRepository;
import com.hrms.profile.service.ExamTypeService;

@Service
public class ExamTypeServiceImpl implements ExamTypeService{

	@Autowired
	ExamTypeRepository examTypeRepository;
	@Autowired
	AcademicQualificationRepository academicQualificationRepository;
	
	@Override
	public ResponseEntity<?> addExamType(@RequestBody ExamType examType) throws URISyntaxException {
		
		Optional<ExamType> eTFromDB = examTypeRepository.findById(examType.getId());
		
		if(eTFromDB.isPresent())
			throw new ResourceAlreadyExistsException(examType.getId(), ExamType.class.getSimpleName());
		
		ExamType eT = examTypeRepository.save(examType);
		
		return new ResponseEntity<ExamType>(eT, HttpStatus.CREATED);
	}

	
	@Override
	public ResponseEntity<List<ExamType>> getAllExamTypes() {
		
		List<ExamType> eTList = examTypeRepository.findAll();
		
		if(eTList.isEmpty())
			//return new ResponseEntity<List<ExamType>>(HttpStatus.NO_CONTENT); 
			throw new ResourceNotFoundException(null, ExamType.class.getSimpleName());
		
		return new ResponseEntity<List<ExamType>>(eTList, HttpStatus.FOUND);
	}

	
	@Override
	public ResponseEntity<ExamType> getExamTypeById(Integer id) {
		
		ExamType eT = examTypeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(id, ExamType.class.getSimpleName()));
		
		return new ResponseEntity<ExamType>(eT, HttpStatus.FOUND);
	}

	
	@Override
	public ResponseEntity<?> deleteExamType(Integer id) {

		examTypeRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException(id, ExamType.class.getSimpleName()));
		
		examTypeRepository.deleteById(id);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

	
	@Override
	public ResponseEntity<?> editExamType(ExamType examType, Integer id) throws URISyntaxException {
		
		examTypeRepository.findById(examType.getId())
			.orElseThrow(()-> new ResourceNotFoundException(examType.getId(), ExamType.class.getSimpleName()));
		
		ExamType eT = examTypeRepository.save(examType);
		
		return new ResponseEntity<ExamType>(eT, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<List<ExamType>> searchByName(String name) {
		
		List<ExamType> eTList = examTypeRepository.findByExamTypeName(name);
		
		if(eTList.isEmpty())
			throw new ResourceNotFoundException(null, ExamType.class.getSimpleName());
		
		return new ResponseEntity<List<ExamType>>(eTList, HttpStatus.FOUND);
	}

		
	public ResponseEntity<List<ExamType>> searchByAcademicQualification(Integer academicQualificationId) {
	
		AcademicQualification aQ = academicQualificationRepository.findById(academicQualificationId)
				.orElseThrow(()-> new ResourceNotFoundException(academicQualificationId, AcademicQualification.class.getSimpleName()));
				
		List<ExamType> eTList = examTypeRepository.findByAcademicQualification(aQ);
		
		if(eTList.isEmpty())
			throw new ResourceNotFoundException(null, ExamType.class.getSimpleName());
		
		return new ResponseEntity<List<ExamType>>(eTList, HttpStatus.FOUND);
	}

	
	@Override
	public ResponseEntity<?> addExamTypeResource(ExamType examType) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resources<Resource<ExamType>> getAllExamTypeResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<ExamType> getExamTypeResourceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> editExamTypeResource(ExamType examType, Integer id) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}


	

	

}
