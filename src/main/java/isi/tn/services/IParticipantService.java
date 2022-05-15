package isi.tn.services;

import isi.tn.entities.Participant;
import isi.tn.repository.participantRepository;
import java.util.List;


public interface IParticipantService {
	  Participant saveParticipant(Participant participant);
	
	   List<Participant> findAllParticipants();
	   //Participant findById(Long id);
}




