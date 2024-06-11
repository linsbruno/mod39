package com.kaly.vendinhas.service;

import com.kaly.vendinhas.domain.Produto;
import com.kaly.vendinhas.service.generic.IGenericService;

import java.util.List;

public interface IProdutoService extends IGenericService<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}