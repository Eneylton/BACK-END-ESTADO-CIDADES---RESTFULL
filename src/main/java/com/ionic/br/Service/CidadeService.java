package com.ionic.br.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionic.br.Domain.Cidade;
import com.ionic.br.Repository.CidadeRepositories;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepositories repos;

	public Cidade buscarPorId(Integer id) {
		Optional<Cidade> cat = repos.findById(id);
		return cat.orElse(null);
	}
	
	public List<Cidade> buscar() {
		return repos.findAll();
	}

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repos.save(obj);
	}
	
	public List<Cidade> findByEstado(Integer estadoId) {
		return repos.findCidades(estadoId);
	}

	
}
