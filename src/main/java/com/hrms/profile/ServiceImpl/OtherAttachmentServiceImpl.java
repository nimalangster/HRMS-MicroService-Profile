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

import com.hrms.profile.entity.OtherAttachment;
import com.hrms.profile.entity.User;
import com.hrms.profile.exceptionhandler.ResourceAlreadyExistsException;
import com.hrms.profile.exceptionhandler.ResourceNotFoundException;
import com.hrms.profile.repository.OtherAttachmentRepository;
import com.hrms.profile.repository.UserRepository;
import com.hrms.profile.service.OtherAttachmentService;

@Service
public class OtherAttachmentServiceImpl implements OtherAttachmentService {

	@Autowired
	OtherAttachmentRepository otherAttachmentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<OtherAttachment> addOtherAttachment(OtherAttachment otherAttachment) throws URISyntaxException {
		
		Optional<OtherAttachment> oAFromDB = otherAttachmentRepository.findById(otherAttachment.getId());
		
		if(oAFromDB.isPresent())
			throw new ResourceAlreadyExistsException(otherAttachment.getId(), OtherAttachment.class.getSimpleName());
		
		OtherAttachment oA = otherAttachmentRepository.save(otherAttachment);
				
		return new ResponseEntity<OtherAttachment>(oA, HttpStatus.CREATED);
	}

	
	@Override
	public ResponseEntity<List<OtherAttachment>> getAllOtherAttachments() {
		
		List<OtherAttachment> oAList = otherAttachmentRepository.findAll();
		
		if(oAList.isEmpty())
			throw new ResourceNotFoundException(null, OtherAttachment.class.getSimpleName());
		
		return new ResponseEntity<List<OtherAttachment>>(oAList, HttpStatus.FOUND);
	}
	

	@Override
	public ResponseEntity<OtherAttachment> getOtherAttachmentById(Integer id) {
		
		OtherAttachment oA = otherAttachmentRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException(id, OtherAttachment.class.getSimpleName()));
		
		return new ResponseEntity<OtherAttachment>(oA, HttpStatus.FOUND);
	}

	
	@Override
	public ResponseEntity<HttpStatus> deleteOtherAttachment(Integer id) {

		otherAttachmentRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException(id, OtherAttachment.class.getSimpleName()));
		
		otherAttachmentRepository.deleteById(id);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<OtherAttachment> editOtherAttachment(OtherAttachment otherAttachment, Integer id)
			throws URISyntaxException {
		
		otherAttachmentRepository.findById(otherAttachment.getId())
			.orElseThrow(()-> new ResourceNotFoundException(otherAttachment.getId(), OtherAttachment.class.getSimpleName()));
		
		OtherAttachment oA = otherAttachmentRepository.save(otherAttachment);
		
		return new ResponseEntity<OtherAttachment>(oA, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<List<OtherAttachment>> searchByName(String name) {
		
		List<OtherAttachment> oAList = otherAttachmentRepository.findByAttachmentName(name);
		
		if(oAList.isEmpty())
			throw new ResourceNotFoundException(null, OtherAttachment.class.getSimpleName());
		
		return new ResponseEntity<List<OtherAttachment>>(oAList, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<OtherAttachment>> searchByUser(Integer userId) {
		
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, User.class.getSimpleName()));
		
		List<OtherAttachment> oAList  = otherAttachmentRepository.findByUser(user);
		
		if(oAList.isEmpty())
			throw new ResourceNotFoundException(null, OtherAttachment.class.getSimpleName());

		return new ResponseEntity<List<OtherAttachment>>(oAList, HttpStatus.FOUND);
	}
	
	
	@Override
	public ResponseEntity<?> addOtherAttachmentResource(OtherAttachment otherAttachment) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resources<Resource<OtherAttachment>> getAllOtherAttachmentResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<OtherAttachment> getOtherAttachmentResourceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> editOtherAttachmentResource(OtherAttachment otherAttachment, Integer id)
			throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}


	

}
