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
public class Pays implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="paysid")
	private Long id;
	@Column(unique=true)
	private String libelle;
	
	
		@OneToMany(mappedBy="pays",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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
	
	
	@Override
	public String toString() {
		return "Pays [id=" + id + ", nom=" + libelle + ", participants=" + participants + "]";
	}
	public Pays() {
		super();
	}
	
}



