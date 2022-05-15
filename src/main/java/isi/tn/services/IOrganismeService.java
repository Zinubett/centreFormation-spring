package isi.tn.services;
import java.util.List;

import isi.tn.entities.Organisme;

public interface IOrganismeService {
	Organisme saveOrganisme(Organisme organisme);

	List<Organisme> findAllOrganismes();
}
