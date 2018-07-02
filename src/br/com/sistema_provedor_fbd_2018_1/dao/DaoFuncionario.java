package br.com.sistema_provedor_fbd_2018_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.business.BusinessFuncionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLConnection;
import br.com.sistema_provedor_fbd_2018_1.sql.SQLUtil;

public class DaoFuncionario  implements IDaoFuncionario{
	
	
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public void salvar(Funcionario funcionario) {
		
		conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONEXAO_POSTGRES);
		try {
			statement = conexao.prepareStatement(SQLUtil.Endereco.MAXID);
			ResultSet resultSet =  statement.executeQuery();
			resultSet.next();
			int endereco_id = resultSet.getInt(1);
			
			
			statement =  conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);
			
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCargo());
			statement.setDate(3, BusinessFuncionario.converterParaData(funcionario.getData_contrato()));
			statement.setString(4, funcionario.getLogin());
			statement.setString(5,funcionario.getSenha());
			statement.setInt(6, endereco_id);
			
			statement.execute();
			
			conexao.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
