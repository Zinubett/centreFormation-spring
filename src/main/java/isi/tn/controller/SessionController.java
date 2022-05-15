package isi.tn.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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




import isi.tn.entities.sessionFormation;

import isi.tn.repository.sessionRepository;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/session")
public class SessionController  {
	
	@Autowired
	sessionRepository rep;

	
	@GetMapping("/")
	public List<sessionFormation> getAll() {
		List<sessionFormation> pro = rep.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public sessionFormation create(@Valid @RequestBody sessionFormation session) {
	    return rep.save(session);
	}
	

	
	@GetMapping("/{id}")
	public sessionFormation getById(@PathVariable(value = "id") Long Id) {
	    return rep.findById(Id).orElseThrow(null);
	           
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Id) {
		sessionFormation formation = rep.findById(Id).orElseThrow(null);
	            
	    rep.delete(formation);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public sessionFormation update(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody sessionFormation Details) {

		sessionFormation user = rep.findById(Id).orElseThrow(null);
	    
	   user.setDate_debut(Details.getDate_debut());
	   user.setDate_fin(Details.getDate_fin());
	   user.setFormateur(Details.getFormateur());
	   user.setFormation(Details.getFormation());
	   user.setId(Details.getId());
	   user.setLieu(Details.getLieu());
	   user.setNb_participant(Details.getNb_participant());
	   user.setOrganisme(Details.getOrganisme());

	    sessionFormation updated = rep.save(user);
	    return updated;
	}
	
	
	
	
	
	
	
}

