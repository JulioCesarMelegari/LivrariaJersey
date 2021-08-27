package br.com.JCM.livraria.heroku.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import br.com.JCM.livraria.heroku.model.Livro;
import br.com.JCM.livraria.heroku.model.Livros;
import br.com.JCM.livraria.heroku.repositorio.LivroRepositorio;
import br.com.JCM.livraria.heroku.repositorio.exception.LivroNaoEncontradoException;

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
		try {
			return livroRepo.getLivroPorIsbn(isbn);
		}catch(LivroNaoEncontradoException e) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

}
