package br.com.JCM.livraria.heroku.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="livro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Livro {
	
	@XmlAttribute
	private Long id;
	@XmlElement
	private String titulo;
	@XmlElement
	private String isbn;
	@XmlElement
	private String genero;
	@XmlElement
	private Double preço;
	@XmlElement
	private List<Autor> autor = new ArrayList<Autor>();
	
	public Livro() {}
	
	public Livro(Long id, String titulo, String isbn, String genero, Double preço, String... nomes) {
		
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.genero = genero;
		this.preço = preço;
		
		for (String nome: nomes) {
			autor.add(new Autor(nome));
		}
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	public List<Autor> getAutor() {
		return autor;
	}
	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}
	
	

}
