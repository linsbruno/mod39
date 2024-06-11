package com.kaly.vendinhas.dao;

import com.kaly.vendinhas.dao.generic.IGenericDAO;
import com.kaly.vendinhas.domain.Produto;

import java.util.List;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}
