package isi.tn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.Organisme;

@Repository
public interface organismeRespository extends JpaRepository<Organisme,Long>{

}
