package br.edu.utfpr.alunos.model;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue
	protected int id;
	
	private String descricao;
	private String local;
	private LocalTime horario;
	private Date data;
	private char status;
	
	@ManyToMany
	private Set<User> users;
	
	public Item() {	
	}
	
	public Item(String descricao, String local, LocalTime horario, 
			Date date, char status, Set<User> users) {
		super();
		this.descricao = descricao;
		this.local = local;
		this.horario = horario;
		this.data = date;
		this.setStatus(status);
		this.users = users;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Date getDate() {
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}	
}
