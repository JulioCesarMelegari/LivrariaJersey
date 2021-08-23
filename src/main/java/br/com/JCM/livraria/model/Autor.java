package br.com.JCM.livraria.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="autor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Autor {
	
	@XmlAttribute
	private Long id;
	@XmlElement
	private String nome;
	
	public Autor() {}
	
	public Autor(String nome) {
		this.id = Math.round(Math.random()*10);
		this.nome = nome;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
