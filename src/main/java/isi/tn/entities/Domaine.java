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
public class Domaine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="domaineid")
	private Long id;
	private String libelle;
	@OneToMany(mappedBy="domaine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<Formation> formations;
	
	
	public Set<Formation> getFormations() {
		return formations;
	}
	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	
	
	public Domaine(Long id, String libelle, Set<Formation> formations) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.formations = formations;
	}
	@Override
	public String toString() {
		return "Domaine [id=" + id + ", libelle=" + libelle + ", formations=" + formations + "]";
	}
	public Domaine() {
		super();
	}
}
