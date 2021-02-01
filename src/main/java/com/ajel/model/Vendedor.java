package com.ajel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="pcusuari")
public class Vendedor {
	
	@Id
    @Column(name = "codusur")
	private long codusur;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "bloqueio")
	private String bloqueio;
	
	@Column(name = "email")
	private String email;
	
	public Vendedor(){
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codusur ^ (codusur >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (codusur != other.codusur)
			return false;
		return true;
	}


	public Vendedor(long codusur, String nome, String bloqueio, String email) {
		super();
		this.codusur = codusur;
		this.nome = nome;
		this.bloqueio = bloqueio;
		this.email = email;
	}
	
	
	public long getCodusur() {
		return codusur;
	}

	public void setCodusur(long codusur) {
		this.codusur = codusur;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	};
	
	
}
