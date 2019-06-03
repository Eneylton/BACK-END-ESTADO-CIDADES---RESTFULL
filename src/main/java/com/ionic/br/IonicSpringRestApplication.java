package com.ionic.br;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ionic.br.Domain.Categoria;
import com.ionic.br.Domain.Cidade;
import com.ionic.br.Domain.Estado;
import com.ionic.br.Domain.Produto;
import com.ionic.br.Repository.CategoriaRepositories;
import com.ionic.br.Repository.CidadeRepositories;
import com.ionic.br.Repository.EstadoReposiories;
import com.ionic.br.Repository.ProdutoRepositories;

@SpringBootApplication
public class IonicSpringRestApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositories catRepos;

	@Autowired
	private ProdutoRepositories prodRepos;

	@Autowired
	private EstadoReposiories estadoRepos;

	@Autowired
	private CidadeRepositories cidadeRepos;

	public static void main(String[] args) {
		SpringApplication.run(IonicSpringRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		catRepos.saveAll(Arrays.asList(cat1, cat2));

		Produto pro1 = new Produto(null, "Impressora", 340.90);
		Produto pro2 = new Produto(null, "Processador", 340.90);
		Produto pro3 = new Produto(null, "Gabinete", 340.90);
		Produto pro4 = new Produto(null, "Mesa para Cpu", 740.90);
		Produto pro5 = new Produto(null, "Cadeira", 540.90);

		cat1.getProdutos().addAll(Arrays.asList(pro1, pro2, pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro4, pro5));

		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		pro4.getCategorias().addAll(Arrays.asList(cat2));
		pro5.getCategorias().addAll(Arrays.asList(cat2));

		prodRepos.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));

		Estado est1 = new Estado(null, "Maranhão");
		Estado est2 = new Estado(null, "Para");
		Estado est3 = new Estado(null, "Piaui");

		estadoRepos.saveAll(Arrays.asList(est1, est2, est3));

		Cidade cid1 = new Cidade(null, "São Luís", est1);
		Cidade cid2 = new Cidade(null, "Imperatriz",est1);
		Cidade cid3 = new Cidade(null, "Riachão",est1);
		Cidade cid4 = new Cidade(null, "Belém",est2);
		Cidade cid5 = new Cidade(null, "Terezina",est3);

		cidadeRepos.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5));
	}

}
