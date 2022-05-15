package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import isi.tn.entities.Profil;
@Repository
public interface profilRepository extends JpaRepository<Profil,Long> {

}
