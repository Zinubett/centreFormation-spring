package isi.tn.services;
import java.util.List;

import isi.tn.entities.Domaine;
import isi.tn.entities.Organisme;
import isi.tn.entities.Participant;

public interface IDomaineService {
	Domaine saveDomaine(Domaine domaine);

	List<Domaine> findAllDomaines();



	
}
