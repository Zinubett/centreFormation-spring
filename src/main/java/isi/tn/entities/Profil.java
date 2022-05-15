package isi.tn.entities;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


//import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Profil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="profilid")
	private Long id;
	@Column(unique=true)
	private String libelle;
	
	@OneToMany(mappedBy="profil",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<Participant> participants;
	
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Profil(Long id, String libelle, Set<Participant> participants) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.participants = participants;
	}
	
	
	@Override
	public String toString() {
		return "Profil [id=" + id + ", libelle=" + libelle + ", participants=" + participants + "]";
	}
	public Profil() {
		super();
	}
}
;


