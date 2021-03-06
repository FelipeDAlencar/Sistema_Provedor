package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoSwitch implements IDaoSwitch {
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Switch switch1, String nomeCaixa, String nomeConcentrador) throws DaoException {
		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Caixa.SELECT_NOME);
			statement.setString(1, nomeCaixa);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int caixa_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Concentrador.SELECT_NOME);
			statement.setString(1, nomeConcentrador);
			resultSet = statement.executeQuery();
			resultSet.next();

			int con_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Switch.INSERT_ALL);

			statement.setString(1, switch1.getNome());
			statement.setInt(2, switch1.getNumero_de_portas());
			statement.setString(3, switch1.getIp());
			statement.setString(4, switch1.getLogin());
			statement.setString(5, switch1.getSenha());
			statement.setInt(6, caixa_id);
			statement.setInt(7, con_id);

			statement.execute();
			
			statement=conexao.prepareStatement(SQLUtil.Switch.SELECT_MAXID);
			resultSet = statement.executeQuery();
			resultSet.next();
			Switch sw = new Switch(resultSet.getInt(1));
			
			statement = conexao.prepareStatement(SQLUtil.Porta.INSERT_ALL);
			for(int i=0; i< switch1.getNumero_de_portas();i++) {
				statement.setInt(2, sw.getId());
				statement.setInt(1, i+1);
				statement.execute();
			}
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO INSERIR SWITCH - CONTACTE A EQUIPE RESPONS�VEL - DAO");

		}

	}

	@Override
	public void editar(Switch sw, String nomeCaixa, String nomeConcentrador) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Caixa.SELECT_NOME);
			statement.setString(1, nomeCaixa);

			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			int caixa_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Concentrador.SELECT_NOME);
			statement.setString(1, nomeConcentrador);
			resultSet = statement.executeQuery();
			resultSet.next();

			int con_id = resultSet.getInt(1);

			statement = conexao.prepareStatement(SQLUtil.Switch.UPDATE);

			statement.setString(1, sw.getNome());
			statement.setInt(2, sw.getNumero_de_portas());
			statement.setString(3, sw.getIp());
			statement.setString(4, sw.getLogin());
			statement.setString(5, sw.getSenha());
			statement.setInt(6, caixa_id);
			statement.setInt(7, con_id);
			statement.setInt(8, sw.getId());

			statement.execute();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO EDITAR SWITCH - DAO");
		}

	}

	@Override
	public Switch buscarPorId(int id) throws DaoException {	
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Switch.SELECT_ID);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			Switch sw;
			if (resultSet.next()) {
				sw = new Switch(
						resultSet.getInt(1),
						resultSet.getInt(7),
						resultSet.getInt(8),
						resultSet.getString(2),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(3));
			}else {
				throw new DaoException("SWITCH N�O ENCONTRADO - DAO");
			}

			conexao.close();
			return sw;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SWITCH - DAO");
		}
	}

	@Override
	public ArrayList<Switch> listarTodos() throws DaoException {

		try {

			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Switch.SELECT_ALL);
			ArrayList<Switch> switchs = new ArrayList<>();
			Switch switch1;

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				switch1 = new Switch(
						resultSet.getInt(1),
						resultSet.getInt(7),
						resultSet.getInt(8),
						resultSet.getString(2),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(3));

				switchs.add(switch1);
			}
			return switchs;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO LISTAR SWITCH'S");
		}

	}

	@Override
	public ArrayList<Switch> buscarPorBusca(String busca)throws DaoException {

		try {
			conexao =  SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Switch.SELECT_PORBUSCA);

			statement.setString(1, '%' + busca + '%');
			statement.setString(2, '%' + busca + '%');
			statement.setString(3, '%' + busca + '%');

			ResultSet resultSet = statement.executeQuery();

			ArrayList<Switch> switchs =  new ArrayList<>();
			Switch switch1;

			while(resultSet.next()) {
				switch1 = new Switch(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("ip"), resultSet.getString("login"), "", resultSet.getInt("numero_de_portas"));
				switchs.add(switch1);

			}
			return switchs;


		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SWITCH");
		}


	}

	@Override
	public Switch buscarPorNome(String nome) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
			statement = conexao.prepareStatement(SQLUtil.Switch.SELECT_NOME);
			
			statement.setString(1, nome);
			
			
			ResultSet resultSet = statement.executeQuery();
			Switch switch1;
			if (resultSet.next()) {
				switch1 = new Switch(resultSet.getInt("id"), resultSet.getString("nome"));
			}else {
				throw new DaoException("SWITCH N�O ENCONTRADO - DAO");
			}
			
			return switch1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("ERRO AO BUSCAR SWITCH CONTATE A EQUIPE RESPONSAVEL - DAO");
		}
		
	}


}
