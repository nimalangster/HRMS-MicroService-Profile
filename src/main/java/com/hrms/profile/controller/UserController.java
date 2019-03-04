package com.hrms.profile.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.profile.entity.User;
import com.hrms.profile.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	 // -------------------Retrieve All Users---------------------------------------------
	 
	@ApiOperation(value= " List all the users in the HRMS ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Returning the list successfully."),
							@ApiResponse(code = 401, message = " You are not authorised to view the list.")})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {        
        return userService.getAllUsers();
    }
 
    // -------------------Retrieve Single User------------------------------------------
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {           
        return userService.getUserById(id);
    }
	
    // -------------------Add Single User------------------------------------------
	
	@PostMapping("")
	ResponseEntity<?> addUser(@RequestBody User newUser) throws URISyntaxException {
		return userService.addUser(newUser);		
	}	
	
	 // -------------------Edit Single User------------------------------------------
	
	@PutMapping("/{id}")
	ResponseEntity<?> editUser(@RequestBody User newUser, @PathVariable Integer id) throws URISyntaxException {		
		return userService.editUser(newUser, id);
	}	

	 // -------------------Delete Single User------------------------------------------
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		
		return userService.deleteUser(id);		
		
	}    
	
	// -------------------Search Users---------------------------------------------
	 
    @RequestMapping(value = "/search/{name}/{nic}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByName(@PathVariable String name, @PathVariable String nic) {        
        return userService.searchByName(name,nic);
    }

    
//  HATEOS USER Controllers FOR HYPERMEDIA ENABLED CLIENTS.
	
	@PostMapping("/userresource")
	ResponseEntity<?> addUserResource(@RequestBody User newUser) throws URISyntaxException {
		return userService.addUserResource(newUser);		
	}
	
	
	@GetMapping("/userresource/{id}")
	public Resource <User> getUserResourceById(@PathVariable Integer id) {		
		return userService.getUserResourceById(id);		
	}	

	
	@GetMapping("/userresource")
	public Resources<Resource<User>> getAllUserResources() {
		return userService.getAllUserResources();
	}
	
	
	@PutMapping("/userresource/{id}")
	ResponseEntity<?> editUserResource(@RequestBody User newUser, @PathVariable Integer id) throws URISyntaxException {		
		return userService.editUserResource(newUser, id);
	}		
	
		
}
