package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Participant;
import isi.tn.repository.participantRepository;

@Service
public class ImpParticipant implements IParticipantService{
	@Autowired
	participantRepository prepos;

	@Override
	public 	 Participant saveParticipant (Participant participant) {
		// TODO Auto-generated method stub
		return prepos.save(participant);
	}

	@Override
	public List<Participant>findAllParticipants() {
		// TODO Auto-generated method stub
		return prepos.findAll();
	}
}
