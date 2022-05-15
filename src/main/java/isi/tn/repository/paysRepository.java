package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import isi.tn.entities.Pays;
@Repository
public interface paysRepository extends JpaRepository<Pays,Long> {

}
