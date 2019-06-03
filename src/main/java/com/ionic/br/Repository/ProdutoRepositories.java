package com.ionic.br.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionic.br.Domain.Produto;

@Repository
public interface ProdutoRepositories extends JpaRepository<Produto, Integer> {

}
