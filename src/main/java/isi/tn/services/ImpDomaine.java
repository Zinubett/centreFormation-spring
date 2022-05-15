package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Domaine;
import isi.tn.entities.User;
import isi.tn.repository.domaineRepository;

@Service
public class ImpDomaine implements IDomaineService{
	@Autowired
	domaineRepository drepos;

	@Override
	public 	Domaine saveDomaine(Domaine domaine) {
		// TODO Auto-generated method stub
		return drepos.save(domaine);
	}

	@Override
	public List<Domaine> findAllDomaines() {
		// TODO Auto-generated method stub
		return drepos.findAll();
	}
}
