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




import isi.tn.entities.Formation;

import isi.tn.repository.formationRepository;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formation")
public class FormationController {
	
	@Autowired
	formationRepository rep;

	
	@GetMapping("/")
	public List<Formation> getAll() {
		List<Formation> pro = rep.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public Formation create(@Valid @RequestBody Formation formation) {
	    return rep.save(formation);
	}
	

	
	@GetMapping("/{id}")
	public Formation getById(@PathVariable(value = "id") Long Id) {
	    return rep.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Id) {
	    Formation formation = rep.findById(Id).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    rep.delete(formation);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Formation update(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Formation Details) {

	    Formation user = rep.findById(Id).orElseThrow(null);
	    
	   user.setTitre(Details.getTitre());
	   user.setDomaine(Details.getDomaine());
	   user.setType_formation(Details.getType_formation());
	    user.setNb_session(Details.getNb_session());
	    user.setDuree(Details.getDuree());
	    user.setBudget(Details.getBudget());
	    user.setSession(Details.getSession());
	    user.setAnnée(Details.getAnnée());

	   Formation updated = rep.save(user);
	    return updated;
	}
	
	
	
	
	
	
	
}

