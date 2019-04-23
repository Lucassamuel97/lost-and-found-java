package br.edu.utfpr.alunos.model;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	@Id
	protected int id;
	
	private String descricao;
	private String local;
	private LocalTime horario;
	private Date date;
	private char status;
	private int id_user;
	
	public Item() {
		
	}

	public Item(int id, String descricao, String local, LocalTime horario, Date date, char status, int id_user) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.local = local;
		this.horario = horario;
		this.date = date;
		this.setStatus(status);
		this.id_user = id_user;
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
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}	
}
