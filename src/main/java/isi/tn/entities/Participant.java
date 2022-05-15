package isi.tn.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


//import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Participant implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Set<sessionFormation> getSessionFormation() {
		return sessionFormation;
	}
	public void setSessionFormation(Set<sessionFormation> sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private String email;
	
	@ManyToMany(mappedBy = "participant", fetch= FetchType.LAZY)
	@JsonIgnore
	private Set <sessionFormation> sessionFormation;
	private int tel;
	@Enumerated (EnumType.STRING)
	private Type type;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonManagedReference
	//@JsonIgnore
	
	@ManyToOne
	@JoinColumn(name="pays_id")
	private Pays pays;
	
	@ManyToOne
	@JoinColumn(name="profil_id")
	private Profil profil;
	
	@ManyToOne
	@JoinColumn(name="organisme_id")
	private Organisme organisme;
	
	public Long getId() {
		return id;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public Organisme getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}

	
	
	
	
	
	
	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", sessionFormation=" + sessionFormation + ", tel=" + tel + ", type=" + type + ", pays=" + pays
				+ ", profil=" + profil + ", organisme=" + organisme + "]";
	}
	public Participant() {
		super();
	}
	
	

}

