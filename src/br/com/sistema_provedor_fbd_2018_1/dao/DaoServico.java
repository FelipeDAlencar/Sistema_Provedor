package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoServico implements IDaoServico {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Servico servico) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Servico.INSERT_ALL);

			statement.setString(1, servico.getNome());
			statement.setInt(2, servico.getDownload());
			statement.setInt(3, servico.getUpload());

			statement.execute();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR SERVICO- CONTACTE A EQUIPE RESPONS�VEL - DAO");

		}

	}

	@Override
	public void editar(Servico servico) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Servico buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Servico> listarTodos() throws DaoException {

		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement =  conexao.prepareStatement(SQLUtil.Servico.SELECT_ALL);

			ArrayList<Servico> servicos = new ArrayList<>();
			Servico servico;

			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				servico =  new Servico(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
				servicos.add(servico);
			}
			conexao.close();
			return servicos;


		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR TODOS OS  CONCENTRADORES");
		}

	}

	@Override
	public List<Servico> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
