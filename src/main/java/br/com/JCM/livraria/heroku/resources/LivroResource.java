package br.com.JCM.livraria.heroku.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.JCM.livraria.heroku.model.Livro;
import br.com.JCM.livraria.heroku.model.Livros;
import br.com.JCM.livraria.heroku.repositorio.LivroRepositorio;

@Path("livro")
public class LivroResource {
	
	private LivroRepositorio livroRepo = new LivroRepositorio();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Livros getLivros() {
		Livros livros = new Livros();
		livros.setLivros(livroRepo.getLivros());
		return livros;
	}
	
	@GET
	@Path("/{isbn}")
	public Livro getLivroPorIbn(@PathParam("isbn") String isbn) {
		return livroRepo.getLivroPorIsbn(isbn);
	}
	

}
