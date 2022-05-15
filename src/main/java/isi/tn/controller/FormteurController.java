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



import isi.tn.entities.Formateur;


import isi.tn.repository.formateurRepository;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formateurs")
public class FormteurController {
	
	@Autowired
	formateurRepository rep;

	
	@GetMapping("/")
	public List<Formateur> getAllFormateurs() {
		List<Formateur> pro = rep.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public Formateur create(@Valid @RequestBody Formateur partici) {
	    return rep.save(partici);
	}
	

	
	@GetMapping("/{id}")
	public Formateur getById(@PathVariable(value = "id") Long Id) {
	    return rep.findById(Id).orElseThrow(null);
	           
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteParticipant(@PathVariable(value = "id") Long Id) {
	   Formateur formateur = rep.findById(Id).orElseThrow(null);
	           
	    rep.delete(formateur);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Formateur update(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Formateur Details) {

	   Formateur user = rep.findById(Id).orElseThrow(null);
	    
	   user.setEmail(Details.getEmail());
	   user.setNom(Details.getNom());
	    user.setTel(Details.getTel());
	    user.setPrenom(Details.getPrenom());
	    user.setOrganisme(Details.getOrganisme());
	    user.setType(Details.getType());
	    Formateur updated = rep.save(user);
	    return updated;
	}
	
	
	
	
	
	
	
}

