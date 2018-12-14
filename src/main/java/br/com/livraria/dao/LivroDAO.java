package br.com.livraria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivrariaRepository;

public class LivroDAO implements LivrariaRepository {

	//Aqui estou chamando uma entitymanager, pois é ele quem gerencia as transacoes
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("livrariaPU");
	EntityManager em = factory.createEntityManager();

	//Aqui eu estou salvando um livro
	//Tente iniciar uma transacao, depois de iniciar abro a transacao
	//se o id do livro for igual a null(vazio) persista um livro
	//caso nao faça um merge(update)
	public void save(Livro livro) {
		try {
			//iniciando a transacao
			em.getTransaction().begin();
			if (livro.getId() == null) {
				em.persist(livro);
			} else {
				em.merge(livro);
			}
			//comitando td
			em.getTransaction().commit();

		} catch (Exception e) {
			em.close();
		}

	}

	//deletando o livro pelo id
	//tenta iniciar uma transacao, incio a transacao.
	//busque o livro com id X, achando esse id X
	//delete a faz commit
	public void delete(Long id) {
		 try {
			 em.getTransaction().begin();
			 Livro livro = em.find(Livro.class, id);
			 em.remove(livro);
			 em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 em.close();
	}

	//buscando livro pelo id
	//tenta achar o livro com id X
	//se achar o livro com id X me retorne	
	public Livro getById(Long id) {
		Livro livro = null;
		try {
			livro = em.find(Livro.class, id);
		} catch (Exception e) {
			em.close();
		}
		return livro;
	}

	@SuppressWarnings("unchecked")
	public List<Livro> getAll() {
		   Query query = em.createQuery("select a from Livro a");
		   List<Livro> livros = query.getResultList();
		   for(Livro livro: livros) {
			   System.out.println("Titulo: "+livro.getTituloLivro());
			   System.out.println("*********************************");
			   System.out.println("Autor: "+livro.getNomeAutor());
			   System.out.println("*********************************");
			   System.out.println("Paginas: "+livro.getNumeroPaginas());
			   System.out.println("*********************************");
			   System.out.println("Edicao: "+livro.getEdicao());
		   }
		   
		return livros;
	}
	
	
	
	
	
	
	
	
	
	

}
