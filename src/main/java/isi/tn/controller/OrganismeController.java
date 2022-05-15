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



import isi.tn.entities.Organisme;

import isi.tn.repository.organismeRespository;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/organisme")
public class OrganismeController {
	
	@Autowired
	organismeRespository org;
	
	
	
	@GetMapping("/")
	public List<Organisme> getAllOrganisme() {
		List<Organisme> pro = org.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public Organisme createProfil(@Valid @RequestBody Organisme organisme) {
	    return org.save(organisme);
	}

	
	@GetMapping("/{id}")
	public Organisme getOrganismeById(@PathVariable(value = "id") Long Id) {
	    return org.findById(Id).orElseThrow(null);
	           
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProfil(@PathVariable(value = "id") Long Id) {
		Organisme user =org.findById(Id).orElseThrow(null);
	         
		org.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Organisme updateOrganisme(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Organisme userDetails) {

		Organisme user = org.findById(Id).orElseThrow(null);
	    
	   
	    user.setLibelle(userDetails.getLibelle());
	    user.setParticipants(userDetails.getParticipants());
	   

	    Organisme updatedUser = org.save(user);
	    return updatedUser;
	}
	
	

	
	
	
	
}





