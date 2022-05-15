package isi.tn.entities;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


//import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class sessionFormation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="sessionid")
	private Long id;
	@Column(unique=true)
	private String lieu;
	private Date date_debut;
	private Date date_fin;
	@ManyToMany
	@JsonIgnore
	private Set <Participant> participant =new HashSet<>();
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Organisme getOrganisme() {
		return organisme;
	}
	
	public Set<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}
	private int nb_participant;
	
	@ManyToOne
	@JoinColumn(name="formation_id")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="formateur_id")
	private Formateur formateur;
	
	
	@ManyToOne
	@JoinColumn(name="organisme_id")
	private Organisme organisme;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public int getNb_participant() {
		return nb_participant;
	}
	public void setNb_participant(int nb_participant) {
		this.nb_participant = nb_participant;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "sessionFormation [id=" + id + ", lieu=" + lieu + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", participant=" + participant + ", nb_participant=" + nb_participant + ", formation=" + formation
				+ ", formateur=" + formateur + ", organisme=" + organisme + "]";
	}
	public sessionFormation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}




