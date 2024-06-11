package com.kaly.vendinhas.dao;

import com.kaly.vendinhas.dao.generic.IGenericDAO;
import com.kaly.vendinhas.domain.Cliente;

import java.util.List;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    List<Cliente> filtrarClientes(String query);

}
