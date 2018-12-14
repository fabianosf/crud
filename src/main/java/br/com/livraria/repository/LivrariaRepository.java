package br.com.livraria.repository;

 

import java.util.List;

import br.com.livraria.model.Livro;

public interface LivrariaRepository {
	
	 public void save(Livro livro);	  
	 public void delete(Long id);
	 public Livro getById(Long id);
	 public List<Livro> getAll();
	  
	

}
