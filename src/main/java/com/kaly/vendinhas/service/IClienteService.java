package com.kaly.vendinhas.service;

import com.kaly.vendinhas.domain.Cliente;
import com.kaly.vendinhas.exceptions.DAOException;
import com.kaly.vendinhas.service.generic.IGenericService;

import java.util.List;

public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    List<Cliente> filtrarClientes(String query);

}