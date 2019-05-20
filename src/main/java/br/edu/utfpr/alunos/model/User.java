package br.edu.utfpr.alunos.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.edu.utfpr.alunos.model.Item;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	protected int id;
	
	private String login;
	private String pwd;
	private String telefone;
	private String email;
	
	@ManyToMany
	private Set<Item> item;
	
	public User() {
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User(String login,String pwd, String telefone, String email) {
		this.login = login;
		this.pwd = pwd;
		this.telefone = telefone;
		this.email = email;
	}
	
	public User(int id, String login,String pwd, String telefone, String email) {
		this.id = id;
		this.login = login;
		this.pwd = pwd;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

