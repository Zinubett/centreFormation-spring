package isi.tn.services;
import java.util.List;

import isi.tn.entities.Profil;

public interface IProfilService {
	Profil saveProfil(Profil profil);

	List<Profil> findAllProfils();
}
