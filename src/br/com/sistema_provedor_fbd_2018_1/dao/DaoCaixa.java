package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoCaixa implements IDaoCaixa {
	
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Caixa caixa) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Cidade.SELECT_NOME);
			statement.setString(1, "Ibimirim");

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int cliente_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Caixa.INSERT_ALL);

			statement.setString(1,caixa.getNome());
			statement.setString(2, caixa.getLatitude());
			statement.setString(3, caixa.getLongitude());
			statement.setInt(4, cliente_id);

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR CAIXA - CONTACTE A EQUIPE RESPONSÁVEL - DAO");

		}

		
	}

	@Override
	public void editar(Caixa caixa) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caixa buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Caixa> listarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
