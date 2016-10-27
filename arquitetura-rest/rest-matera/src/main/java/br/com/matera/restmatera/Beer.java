package br.com.matera.restmatera;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beer {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	public Beer(String nome) {
		this.nome = nome;
	}
	public Beer() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
