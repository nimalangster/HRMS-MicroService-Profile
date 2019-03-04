package com.hrms.profile.ServiceImpl;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hrms.profile.controller.UserController;
import com.hrms.profile.entity.AcademicQualification;
import com.hrms.profile.entity.User;
import com.hrms.profile.exceptionhandler.ResourceAlreadyExistsException;
import com.hrms.profile.exceptionhandler.ResourceNotFoundException;
import com.hrms.profile.repository.UserRepository;
import com.hrms.profile.resourceassembler.UserResourceAssembler;
import com.hrms.profile.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserResourceAssembler assembler;

	
	@Override
	public ResponseEntity<?> addUser(User newUser) throws URISyntaxException {
		
		Integer id = newUser.getId();
		
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
				throw new ResourceAlreadyExistsException(id,User.class.getSimpleName());
		}
		User addedUser = userRepository.save(newUser);		
        
        return new ResponseEntity<User>(addedUser, HttpStatus.CREATED);		   
	}
	

	@Override
	public ResponseEntity<?> getAllUsers() {
		
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<Object>("There is no user records!",HttpStatus.NO_CONTENT);              
        }
        return new ResponseEntity<Object>(users, HttpStatus.OK);        
    }
	
	
	@Override
	public ResponseEntity<User> getUserById(Integer id) {
        
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id,User.class.getSimpleName()));

        return new ResponseEntity<User>(user, HttpStatus.FOUND);        
    }


	@Override
	public ResponseEntity<?> deleteUser(Integer id) {	
		
		userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id,User.class.getSimpleName()));
		userRepository.deleteById(id);	
		return new ResponseEntity<>("The record with id "+ id +" is successfully deleted!",HttpStatus.OK);		
	}		

	
	@Override
	public ResponseEntity<?> editUser(User newUser,Integer id) throws URISyntaxException {

		userRepository.findById(newUser.getId())
				.orElseThrow(() -> new ResourceNotFoundException(id,User.class.getSimpleName()));		
		
		User updatedUser = userRepository.save(newUser);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}


	@Override	
	public ResponseEntity<Object> searchByName(String name, String nic){
		
		List<User> users = userRepository.findByFullNameOrNic(name,nic);
		if (users.isEmpty()) {            
			return new ResponseEntity<Object>("There is no user records with user name "+ name +" or with nic "+ nic +" !",HttpStatus.NO_CONTENT);    
        }		
		return new ResponseEntity<Object>(users, HttpStatus.FOUND);
	}

	
//  HATEOS USERSERVICEIMPLEMENTATION FOR HYPERMEDIA ENABLED CLIENTS.
	
	@Override	
	public ResponseEntity<?> addUserResource(@RequestBody User newUser) throws URISyntaxException {

		Resource<User> resource = assembler.toResource(userRepository.save(newUser));

		return ResponseEntity
			.created(new URI(resource.getId().expand().getHref()))
			.body(resource);
	}
	
	@Override	
	public	Resources<Resource<User>> getAllUserResources() {
		
		List<Resource<User>> users = userRepository.findAll().stream()
				.map(assembler::toResource)
			.collect(Collectors.toList());

		return new Resources<>(users,
			linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
	}
	
	@Override	
	public Resource<User> getUserResourceById(Integer id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id,User.class.getSimpleName()));

		return assembler.toResource(user);
		
	}	 
	
	@Override
	public ResponseEntity<?> editUserResource(@RequestBody User newUser, @PathVariable Integer id) throws URISyntaxException {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id,User.class.getSimpleName()));		

		newUser.setId(id);
		User updatedUser = userRepository.save(newUser);	
		Resource<User> resource = assembler.toResource(updatedUser);
		return ResponseEntity
			.created(new URI(resource.getId().expand().getHref()))
			.body(resource);
	}	

}
