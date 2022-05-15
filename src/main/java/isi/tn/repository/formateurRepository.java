package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.Formateur;
@Repository
public interface formateurRepository extends JpaRepository<Formateur,Long> {

}
