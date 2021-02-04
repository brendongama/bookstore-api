package com.brendon.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.bookstore.domain.Categoria;
import com.brendon.bookstore.domain.Livro;
import com.brendon.bookstore.repositories.CategoriaRepository;
import com.brendon.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 =  new Categoria(null, "informatica", "livros de TI");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsun", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
}
