package isi.tn.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.Domaine;

@Repository
public interface domaineRepository extends JpaRepository<Domaine,Long> {

	

	

}
