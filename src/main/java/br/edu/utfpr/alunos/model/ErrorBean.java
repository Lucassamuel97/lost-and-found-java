package br.edu.utfpr.alunos.model;

import java.io.Serializable;

public class ErrorBean implements Serializable{

	private String message;
	
	public ErrorBean() {		
	}
	
	public ErrorBean(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
