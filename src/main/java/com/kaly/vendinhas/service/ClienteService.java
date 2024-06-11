package com.kaly.vendinhas.service;

import com.kaly.vendinhas.dao.IClienteDAO;
import com.kaly.vendinhas.domain.Cliente;
import com.kaly.vendinhas.exceptions.DAOException;
import com.kaly.vendinhas.exceptions.MaisDeUmRegistroException;
import com.kaly.vendinhas.exceptions.TableException;
import com.kaly.vendinhas.service.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;

    @Inject
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> filtrarClientes(String query) {
        return clienteDAO.filtrarClientes(query);
    }

}