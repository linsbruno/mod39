package com.kaly.vendinhas.dao;

import com.kaly.vendinhas.dao.generic.IGenericDAO;
import com.kaly.vendinhas.domain.Venda;
import com.kaly.vendinhas.exceptions.DAOException;
import com.kaly.vendinhas.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Usando este método para evitar a exception org.hibernate.LazyInitializationException
     * Ele busca todos os dados de objetos que tenham colletion pois a mesma por default é lazy
     * Mas você pode configurar a propriedade da collection como fetch = FetchType.EAGER na anotação @OneToMany e usar o consultar genérico normal
     *
     * OBS: Não é uma boa prática utiliar FetchType.EAGER pois ele sempre irá trazer todos os objetos da collection
     * mesmo sem precisar utilizar.
     *
     *
     * @see VendaJpa produtos
     *
     * @param id
     * @return
     */
    public Venda consultarComCollection(Long id);

}