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



import isi.tn.entities.Domaine;

import isi.tn.repository.domaineRepository;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/domaine")
public class DomaineController {
	
	@Autowired
	domaineRepository demv;
	
	
	
	@GetMapping("/")
	public List<Domaine> getAllDomaines() {
		List<Domaine> pro = demv.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public Domaine createDomaine(@Valid @RequestBody Domaine domaine) {
	    return demv.save(domaine);
	}

	
	@GetMapping("/{id}")
	public Domaine getDomaineById(@PathVariable(value = "id") Long Id) {
	    return demv.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDomaine(@PathVariable(value = "id") Long Id) {
		Domaine user = demv.findById(Id).orElseThrow(null);
	         
	   demv.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Domaine updateDomaine(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Domaine userDetails) {

		Domaine  user = demv.findById(Id).orElseThrow(null);
	    
	   
	    user.setLibelle(userDetails.getLibelle());
	  
	   

	    Domaine updatedUser = demv.save(user);
	    return updatedUser;
	}
	
	

	
	
	
	
}
