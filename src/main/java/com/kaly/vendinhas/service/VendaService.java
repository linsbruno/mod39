package com.kaly.vendinhas.service;

import com.kaly.vendinhas.dao.IVendaDAO;
import com.kaly.vendinhas.domain.Venda;
import com.kaly.vendinhas.exceptions.DAOException;
import com.kaly.vendinhas.exceptions.TipoChaveNaoEncontradaException;
import com.kaly.vendinhas.service.generic.GenericService;
import com.kaly.vendinhas.domain.Venda.Status;


import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    IVendaDAO dao;

    @Inject
    public VendaService(IVendaDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CONCLUIDA);
        dao.finalizarVenda(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Status.CANCELADA);
        dao.cancelarVenda(venda);
    }

    @Override
    public Venda consultarComCollection(Long id) {
        return dao.consultarComCollection(id);
    }

    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        entity.setStatus(Status.INICIADA);
        return super.cadastrar(entity);
    }



}
