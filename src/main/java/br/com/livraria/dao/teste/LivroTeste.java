package br.com.livraria.dao.teste;

import br.com.livraria.dao.LivroDAO;
import br.com.livraria.model.Livro;

public class LivroTeste {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// so descomentar e testar !!!!

		Livro livro = new Livro("Python", 795, "Guido Van Rossum", "3�");
		
		LivroDAO dao = new LivroDAO();
		//dao.save(livro); //salvando livro
		
		
		 //Livro livroBusca = dao.getById(1L); //buscando pelo id
		//System.out.println("Consultado o Livro: "+livroBusca.toString());
		
		//dao.delete(1L); //deletando pelo id
		//System.out.println("Livro Removido!");
		
		//Buscando todos
		  dao.getAll();
	}

}
