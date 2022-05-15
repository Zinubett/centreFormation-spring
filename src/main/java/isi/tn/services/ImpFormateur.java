package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Formateur;
import isi.tn.repository.formateurRepository;


@Service
public class ImpFormateur implements IFormateurService{
	@Autowired
	formateurRepository repos;

	@Override
	public 	 Formateur save (Formateur formateur) {
		// TODO Auto-generated method stub
		return repos.save(formateur);
	}

	@Override
	public List<Formateur>findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}
}

