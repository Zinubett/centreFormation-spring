
package isi.tn.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Profil;
import isi.tn.repository.profilRepository;

@Service
public class ImpProfil implements IProfilService{
	@Autowired
	profilRepository prepos;

	@Override
	public  Profil saveProfil(Profil prof) {
		// TODO Auto-generated method stub
		return prepos.save(prof);
	}
	@Override
	public List<Profil> findAllProfils() {
		// TODO Auto-generated method stub
		return prepos.findAll();
	}
}


