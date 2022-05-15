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
public class Organisme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="organismeid")
	private Long id;
	@Column(unique=true)
	private String libelle;
	
	@OneToMany(mappedBy="organisme",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<Participant> participants;
	
	@OneToMany(mappedBy="organisme",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<Formateur> formateurs;
	
	@OneToMany(mappedBy="organisme",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<sessionFormation> session;
	
	
	public Set<sessionFormation> getSession() {
		return session;
	}
	public void setSession(Set<sessionFormation> session) {
		this.session = session;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Set<Formateur> getFormateurs() {
		return formateurs;
	}
	public void setFormateurs(Set<Formateur> formateurs) {
		this.formateurs = formateurs;
	}
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

	@Override
	public String toString() {
		return "Organisme [id=" + id + ", libelle=" + libelle + ", participants=" + participants + ", formateurs="
				+ formateurs + "]";
	}
	public Organisme(Long id, String libelle, Set<Participant> participants, Set<Formateur> formateurs) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.participants = participants;
		this.formateurs = formateurs;
	}
	public Organisme() {
		super();
	}
	
}
