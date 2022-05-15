package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import isi.tn.entities.sessionFormation;
@Repository
public interface  sessionRepository extends JpaRepository<sessionFormation,Long> {

}
