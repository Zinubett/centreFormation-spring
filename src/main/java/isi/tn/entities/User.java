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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import isi.tn.entities.Role;

//import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "login"),
			@UniqueConstraint(columnNames = "pwd") 
		})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String login;
	
	@NotBlank
	@Size(max = 120)
	private String pwd;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
		return "User [id=" + id + ", login=" + login + ", pwd=" + pwd +  "]";
	}
	
	public User(String username, String email) {
		this.login = username;
		this.pwd = email;
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	//@JsonManagedReference//@JsonBackReference
	
	
	
	
	

	
	

}
