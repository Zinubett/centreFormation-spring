
package isi.tn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.Formation;

@Repository
public interface formationRepository extends JpaRepository<Formation,Long>{

}
