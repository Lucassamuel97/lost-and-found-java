package br.edu.utfpr.alunos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue
	protected int id;
	
	private String descricao;
	private String local;
	private String horario;
	private String data;
	private char status;
	
	private int idusersrecord;
	private int iduserfound;
	
	public Item(){	
	}
	
	public Item(int id) {
		this.id = id;
	}
	public Item(int id , String descricao, String local, String horario, 
			String date, char status ) {
		super();
		this.descricao = descricao;
		this.local = local;
		this.horario = horario;
		this.data = date;
		this.setStatus(status);
	}
	
	public Item(String descricao, String local, String horario, 
			String date, char status ) {
		super();
		this.descricao = descricao;
		this.local = local;
		this.horario = horario;
		this.data = date;
		this.setStatus(status);
	}
	
	public Item(String descricao, String local, String horario, 
			String date, char status, int user) {
		super();
		this.descricao = descricao;
		this.local = local;
		this.horario = horario;
		this.data = date;
		this.setStatus(status);
		this.idusersrecord = user;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDate() {
		return data;
	}

	public void setDate(String date) {
		this.data = date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	public int getUsersrecord() {
		return idusersrecord;
	}

	public void setUsersrecord(int usersrecord) {
		this.idusersrecord = usersrecord;
	}

	public int getUserfound() {
		return iduserfound;
	}

	public void setUserfound(int userfound) {
		this.iduserfound = userfound;
	}
	
}
