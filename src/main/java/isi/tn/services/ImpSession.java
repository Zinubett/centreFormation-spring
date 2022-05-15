package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.sessionFormation;
import isi.tn.repository.sessionRepository;

@Service
public class  ImpSession implements IsessionService{
	@Autowired
	sessionRepository repos;

	@Override
	public  sessionFormation save(sessionFormation session) {
		// TODO Auto-generated method stub
		return repos.save(session);
	}
	@Override
	public List<sessionFormation> findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}
}


