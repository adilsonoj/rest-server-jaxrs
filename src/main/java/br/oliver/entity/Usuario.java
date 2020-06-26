package br.oliver.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.Gson;

@Entity
public class Usuario {

	@Id
	private long id;
	private String nome;

	public Usuario(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Usuario() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Object toJson() {
		return new Gson().toJson(this);
	}

}
