package com.ionic.br.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionic.br.Domain.Categoria;
import com.ionic.br.Repository.CategoriaRepositories;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositories repos;

	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> cat = repos.findById(id);
		return cat.orElse(null);
	}
	
	public List<Categoria> buscar() {
		return repos.findAll();
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repos.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		buscarPorId(obj.getId());
		return repos.save(obj);
	}

	
}
