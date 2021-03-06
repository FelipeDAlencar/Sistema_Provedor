package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoContrato {
	
	public void salvar(Contrato contrato,Parcela parcela)throws DaoException;

	public void editar(Contrato contrato)throws DaoException;

	public Contrato buscarPorId(int id)throws DaoException;
	
	public ArrayList<Contrato> listarTodos()throws DaoException;
	
	public List<Contrato> buscarPorBusca(String busca);
	
	public ArrayList<Contrato> buscarPorClienteID(int cliente_id) throws DaoException;

}
