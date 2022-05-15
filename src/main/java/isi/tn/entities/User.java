package isi.tn.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


//import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class User implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	
	
	
	private String login;
	
	
	private String pwd;
	
	
	@Enumerated (EnumType.STRING)
	private Role role;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", pwd=" + pwd + ", role=" + role + "]";
	}
	public User(Long id, String login, String pwd, Role role) {
		super();
		this.id = id;
		this.login = login;
		this.pwd = pwd;
		this.role = role;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	//@JsonManagedReference//@JsonBackReference
	
	
	
	
	

	
	

}
