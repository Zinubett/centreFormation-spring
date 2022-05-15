package isi.tn.services;

import java.util.List;

import isi.tn.entities.sessionFormation;

public interface  IsessionService {

	sessionFormation save(sessionFormation session);

	List<sessionFormation> findAll();
}
