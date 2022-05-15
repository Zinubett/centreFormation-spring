
package isi.tn.entities;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


//import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Formation implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	
	
	private String titre;
	@Enumerated (EnumType.STRING)
	private Type type_formation;
	
	private int nb_session;
	@NotNull
	@Size(min=5,message="Année avec 4 chiffre au minimum ")
	private int Année;
	@NotNull
	private int duree;
	@NotNull
	private double budget;
	@OneToMany(mappedBy="formation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<sessionFormation> session;
	
	@ManyToOne
	@JoinColumn(name="domaine_id")
	private Domaine domaine;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	


	public int getNb_session() {
		return nb_session;
	}


	public void setNb_session(int nb_session) {
		this.nb_session = nb_session;
	}


	public int getAnnée() {
		return Année;
	}


	public void setAnnée(int année) {
		Année = année;
	}


	public Type getType_formation() {
		return type_formation;
	}


	public void setType_formation(Type type_formation) {
		this.type_formation = type_formation;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	public Set<sessionFormation> getSession() {
		return session;
	}


	public void setSession(Set<sessionFormation> session) {
		this.session = session;
	}


	public Domaine getDomaine() {
		return domaine;
	}


	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Formation(Long id, String titre, Type type_formation, int nb_session, int année, int duree, double budget,
			Set<sessionFormation> session, Domaine domaine) {
		super();
		this.id = id;
	
		
		this.titre = titre;
		this.type_formation = type_formation;
		this.nb_session = nb_session;
		Année = année;
		this.duree = duree;
		this.budget = budget;
		this.session = session;
		this.domaine = domaine;
	}


	@Override
	public String toString() {
		return "Formation [id=" + id + ", titre=" + titre + ", type_formation=" + type_formation + ", nb_session="
				+ nb_session + ", Année=" + Année + ", duree=" + duree + ", budget=" + budget + ", session=" + session
				+ ", domaine=" + domaine + "]";
	}


	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	//@JsonManagedReference//@JsonBackReference
	
	
	
	
	

	
	

}
