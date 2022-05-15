package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Organisme;
import isi.tn.repository.organismeRespository;

@Service
public class ImpOrganisme implements IOrganismeService{
	@Autowired
	organismeRespository drepos;

	@Override
	public 	Organisme saveOrganisme(Organisme organisme) {
		// TODO Auto-generated method stub
		return drepos.save(organisme);
	}

	@Override
	public List<Organisme> findAllOrganismes() {
		// TODO Auto-generated method stub
		return drepos.findAll();
	}
}


