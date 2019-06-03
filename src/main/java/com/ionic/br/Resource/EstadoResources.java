package com.ionic.br.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ionic.br.Domain.Cidade;
import com.ionic.br.Domain.Estado;
import com.ionic.br.Service.CidadeService;
import com.ionic.br.Service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResources {

	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estado> findAll(@PathVariable Integer id) {

		Estado estado = service.buscarPorId(id);

		return ResponseEntity.ok().body(estado);
	}

	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Estado obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Estado>> findTodoCidades() {
		List<Estado> list = service.BuscarPorCidade();
		  
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		return ResponseEntity.ok().body(list);
	}
}
