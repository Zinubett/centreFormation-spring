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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


//import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Formateur implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@NotNull
	private String tel;
	@Enumerated (EnumType.STRING)
	private TypeFormateur type;
	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy="formateur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	//@JsonBackReference
	private Set<sessionFormation> session;
	@ManyToOne
	@JoinColumn(name="organisme_id")
	private Organisme organisme;
	
	public Long getId() {
		return id;
	}

	public Organisme getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}
	public void setId(Long id) {
		this.id = id;
	}
	


	public TypeFormateur getType() {
		return type;
	}

	public void setType(TypeFormateur type) {
		this.type = type;
	}

	public Set<sessionFormation> getSession() {
		return session;
	}

	public void setSession(Set<sessionFormation> session) {
		this.session = session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	

	public Formateur() {
		super();
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel
				+ ", type=" + type + ", session=" + session + ", organisme=" + organisme + "]";
	}
	
	

}
