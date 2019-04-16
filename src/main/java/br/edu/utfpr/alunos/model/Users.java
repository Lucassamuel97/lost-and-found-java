package br.edu.utfpr.alunos.model;

public class Users {
	protected int id;
	protected String login;
	protected String pwd;
	protected String telefone;
	protected String email;
	
	public Users() {
	}
	
	public Users(int id) {
		this.id = id;
	}
	
	public Users(String login,String pwd, String telefone, String email) {
		this.login = login;
		this.pwd = pwd;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Users(int id, String login,String pwd, String telefone, String email) {
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

