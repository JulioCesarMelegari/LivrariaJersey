package br.com.JCM.livraria.heroku.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.JCM.livraria.heroku.model.Livro;
import br.com.JCM.livraria.heroku.repositorio.exception.LivroNaoEncontradoException;

public class LivroRepositorio {
	
	private Map<Long, Livro> livros = new HashMap<>();
	
	public LivroRepositorio() {
		Livro livro1 = new Livro(1L, "O Livreiro de Cabul", "ISBN:9788577991082", "Conto", 14.90, "Asne Seierstad");
		Livro livro2 = new Livro(2L, "O Guarani", "ISBN:9788525416117", "Romance", 33.24, "José de Alencar");
		Livro livro3 = new Livro(3L, "Papéis Avulsos", "ISBN:8567097223", "Romance", 24.90, "Machado de Assis");
		Livro livro4 = new Livro(4L, "Assassinato no Expresso Oriente", "ISBN:9788525432995", "Ficção Policial", 25.50, "Agatha Christie");
		Livro livro5 = new Livro(5L, "Auto da Compadecida", "ISBN:8520937829", "Ficção", 44.90, "Ariano Suassuna");
		
		livros.put(livro1.getId(), livro1);
		livros.put(livro2.getId(), livro2);
		livros.put(livro3.getId(), livro3);
		livros.put(livro4.getId(), livro4);
		livros.put(livro5.getId(), livro5);
	
	}
	
	public List<Livro> getLivros(){
		return new ArrayList<>(livros.values());
	}

	public Livro getLivroPorIsbn(String isbn) {
		for (Livro livro : livros.values()) {
			if(isbn.equals(livro.getIsbn())) {
				return livro;
			}
		}
		throw new LivroNaoEncontradoException();
	}

}
