package br.com.sistema_provedor_fbd_2018_1.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public interface IDaoServico {
	
	
	public void salvar(Servico servico)throws DaoException;

	public void editar(Servico servico)throws DaoException;

	public Servico buscarPorId(int id)throws DaoException;
	
	public ArrayList<Servico> listarTodos()throws DaoException;
	
	public List<Servico> buscarPorBusca(String busca);

}
