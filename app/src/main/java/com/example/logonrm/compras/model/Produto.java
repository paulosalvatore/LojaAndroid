package com.example.logonrm.compras.model;

/**
 * Created by logonrm on 20/10/2017.
 */

public class Produto {
	private int id;
	private String nome;

	public Produto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
