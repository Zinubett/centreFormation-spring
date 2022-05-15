package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Formation;
import isi.tn.repository.formationRepository;
import isi.tn.services.IFormationService;


@Service
public class ImpFormation implements IFormationService{
	@Autowired
	formationRepository repos;

	@Override
	public 	 Formation save (Formation formation) {
		// TODO Auto-generated method stub
		return repos.save(formation);
	}

	@Override
	public List<Formation>findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}
}

