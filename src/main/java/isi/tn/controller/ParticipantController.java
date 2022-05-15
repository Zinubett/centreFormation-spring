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



import isi.tn.entities.Participant;
import isi.tn.entities.Pays;

import isi.tn.repository.participantRepository;

import isi.tn.repository.paysRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/participants")
public class ParticipantController {
	
	@Autowired
	participantRepository particrep;
	
	@Autowired
	paysRepository paysrep;
	
	@GetMapping("/")
	public List<Participant> getAllParticipants() {
		List<Participant> pro = particrep.findAll();
        return pro;
	    
	}

	@PostMapping("/add")
	public Participant createPartici(@Valid @RequestBody Participant partici) {
	    return particrep.save(partici);
	}
	

	
	@GetMapping("/{id}")
	public Participant getParticipantById(@PathVariable(value = "id") Long Id) {
	    return particrep.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteParticipant(@PathVariable(value = "id") Long participantId) {
	    Participant participant = particrep.findById(participantId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    particrep.delete(participant);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Participant updateParticipant(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody Participant participantDetails) {

	    Participant user = particrep.findById(Id).orElseThrow(null);
	    
	   user.setEmail(participantDetails.getEmail());
	   user.setNom(participantDetails.getNom());
	   user.setPays(participantDetails.getPays());
	    user.setTel(participantDetails.getTel());
	    user.setPrenom(participantDetails.getPrenom());
	    user.setOrganisme(participantDetails.getOrganisme());
	    user.setProfil(participantDetails.getProfil());

	    Participant updatedParticipant = particrep.save(user);
	    return updatedParticipant;
	}
	
	
	
	
	
	
	
}

