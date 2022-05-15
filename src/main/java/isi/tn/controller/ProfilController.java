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



import isi.tn.entities.Profil;

import isi.tn.repository.profilRepository;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profil")
public class ProfilController {
	
	@Autowired
	profilRepository prof;
	
	
	
	@GetMapping("/")
	public List<Profil> getAllProfils() {
		List<Profil> pro = prof.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public Profil createProfil(@Valid @RequestBody Profil profil) {
	    return prof.save(profil);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProfil(@PathVariable(value = "id") Long Id) {
		Profil user = prof.findById(Id).orElseThrow(null);
	         
		prof.delete(user);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Profil updateProfil(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Profil userDetails) {

		Profil  user = prof.findById(Id).orElseThrow(null);
	    
	   
	    user.setLibelle(userDetails.getLibelle());
	  user.setParticipants(userDetails.getParticipants());
	   

	    Profil updatedUser = prof.save(user);
	    return updatedUser;
	}
	
	

	
	
	
	
}



