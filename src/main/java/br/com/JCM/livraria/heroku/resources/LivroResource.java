package br.com.JCM.livraria.heroku.resources;

import java.awt.MediaTracker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.JCM.livraria.heroku.model.Livros;
import br.com.JCM.livraria.heroku.repositorio.LivroRepositorio;

@Path("livro")
public class LivroResource {
	
	private LivroRepositorio livroRepo = new LivroRepositorio();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Livros getLivros() {
		Livros livros = new Livros();
		livros.setLivros(livroRepo.getLivros());
		return livros;
	}
	

}
