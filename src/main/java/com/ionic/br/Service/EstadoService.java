package com.ionic.br.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionic.br.Domain.Estado;
import com.ionic.br.Repository.EstadoReposiories;

@Service
public class EstadoService {

	@Autowired
	private EstadoReposiories repos;

	public Estado buscarPorId(Integer id) {
		Optional<Estado> cat = repos.findById(id);
		return cat.orElse(null);
	}
	
	public List<Estado> buscar() {
		return repos.findAll();
	}

	public Estado insert(Estado obj) {
		obj.setId(null);
		return repos.save(obj);
	}
	
	public List<Estado> BuscarPorCidade() {
		return repos.findAllByOrderByNome();
	}

	
}
