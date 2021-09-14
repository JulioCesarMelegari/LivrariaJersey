package br.com.JCM.livraria.heroku.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.JCM.livraria.heroku.model.Livro;
import br.com.JCM.livraria.heroku.model.Livros;
import br.com.JCM.livraria.heroku.repositorio.LivroRepositorio;
import br.com.JCM.livraria.heroku.repositorio.exception.LivroExistenteException;
import br.com.JCM.livraria.heroku.repositorio.exception.LivroNaoEncontradoException;

@Path("livro")
public class LivroResource {
	
	private LivroRepositorio livroRepo = LivroRepositorio.getInstance();
	
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
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response criaLivro(Livro livro) {
		
		try {
			livroRepo.adicionaLivro(livro);
		
			} catch (LivroExistenteException e) {
					throw new WebApplicationException(Status.CONFLICT);
			}	
		
		URI uriLocation = UriBuilder.fromPath("livro/{isbn}").build(livro.getIsbn());
		return Response.created(uriLocation).entity(livro).build();
	}
	
	@PUT
	@Path("/{isbn}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response atualizrLivro(@PathParam("isbn") String isbn, Livro livro) {
		try {
			Livro livroEstoque = livroRepo.getLivroPorIsbn(isbn);
					
			livroEstoque.setAutor(livro.getAutor());
			livroEstoque.setGenero(livro.getGenero());
			livroEstoque.setPreço(livro.getPreço());
			livroEstoque.setTitulo(livro.getTitulo());
			
			livroRepo.atualizarLivro(livroEstoque);
		} catch (LivroNaoEncontradoException e) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		
		return Response.ok().entity(livro).build();
	}
	
	@DELETE
	@Path("/{id}")
	public void removeLivro(@PathParam("id") Long id) {
		try {
			livroRepo.removerLivro(id);
		} catch (LivroNaoEncontradoException e) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

}
