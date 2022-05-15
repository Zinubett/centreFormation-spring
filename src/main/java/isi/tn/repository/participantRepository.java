package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.Participant;
@Repository
public interface participantRepository extends JpaRepository<Participant,Long> {

}
