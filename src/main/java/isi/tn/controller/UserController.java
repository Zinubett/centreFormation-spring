package isi.tn.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import isi.tn.entities.User;

import isi.tn.repository.userRepository;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	userRepository userv;
	
	
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		List<User> pro = userv.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public User createUser(@Valid @RequestBody User user) {
	    return userv.save(user);
	}

	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") Long Id) {
	    return userv.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userv.findById(userId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    userv.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody User userDetails) {

	    User user = userv.findById(Id).orElseThrow(null);
	    
	   
	    
	    user.setPwd(userDetails.getPwd());
	    user.setLogin(userDetails.getLogin());
	   user.setRole(userDetails.getRole());

	    User updatedUser = userv.save(user);
	    return updatedUser;
	}
	
	

	
	
	
	
}
