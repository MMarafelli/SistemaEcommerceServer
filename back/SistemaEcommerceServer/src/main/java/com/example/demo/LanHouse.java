package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LanHouse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;	
	private String classe;
	private String origem;
	private String forca;	
	private String inteligencia;
	private String carisma;
	
	public LanHouse() {
		super();
	}

	public LanHouse(Integer codigo, String nome, String classe, String origem, String forca, String inteligencia,
			String carisma) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.classe = classe;
		this.origem = origem;
		this.forca = forca;
		this.inteligencia = inteligencia;
		this.carisma = carisma;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getForca() {
		return forca;
	}

	public void setForca(String forca) {
		this.forca = forca;
	}

	public String getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(String inteligencia) {
		this.inteligencia = inteligencia;
	}

	public String getCarisma() {
		return carisma;
	}

	public void setCarisma(String carisma) {
		this.carisma = carisma;
	}

}
