package isi.tn.services;

import isi.tn.entities.Formation;
import isi.tn.repository.formationRepository;
import java.util.List;


public interface IFormationService {
	  Formation save(Formation formation);
	
	   List<Formation> findAll();
	  
}
