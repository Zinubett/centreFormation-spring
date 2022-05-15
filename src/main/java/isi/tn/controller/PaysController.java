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

import isi.tn.entities.Participant;
import isi.tn.entities.Pays;

import isi.tn.repository.paysRepository;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pays")
public class PaysController {
	
	@Autowired
	paysRepository pays;
	
	@PostMapping("/add")
	public Pays createPays(@Valid @RequestBody Pays pay) {
	    return pays.save(pay);
	}

	
	@GetMapping("/")
	public List<Pays> getAllPays() {
		List<Pays> pro = pays.findAll();
        return pro;
	    
	}

	

	
	@GetMapping("/{id}")
	public Pays getPaysById(@PathVariable(value = "id") Long Id) {
	    return pays.findById(Id).orElseThrow(null);
	          
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePays(@PathVariable(value = "id") Long Id) {
		Pays user = pays.findById(Id).orElseThrow(null);
	         
		pays.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Pays updatePays(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Pays userDetails) {

		Pays  user = pays.findById(Id).orElseThrow(null);
	    
	   
	    user.setLibelle(userDetails.getLibelle());
	  
	    user.setParticipants(userDetails.getParticipants());

	    Pays updatedUser = pays.save(user);
	    return updatedUser;
	}
	
	

	
	
	
	
}



