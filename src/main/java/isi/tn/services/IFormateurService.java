package isi.tn.services;

import isi.tn.entities.Formateur;
import isi.tn.repository.formateurRepository;
import java.util.List;


public interface IFormateurService {
	  Formateur save(Formateur formateur);
	
	   List<Formateur> findAll();
	  
}
