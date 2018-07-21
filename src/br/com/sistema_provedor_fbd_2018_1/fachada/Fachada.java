package br.com.sistema_provedor_fbd_2018_1.fachada;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.business.BusinessAtendimento;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessCaixa;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessCidade;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessCliente;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessConcentrador;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessContato;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessContrato;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessEndereco;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessFuncionario;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessPorta;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessServico;
import br.com.sistema_provedor_fbd_2018_1.business.BusinessSwitch;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessAtendimento;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessCaixa;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessCidade;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessCliente;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessConcentrador;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessContato;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessContrato;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessEndereco;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessFuncionario;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessPorta;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessServico;
import br.com.sistema_provedor_fbd_2018_1.business.IBusinessSwitch;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class Fachada implements IFachada {
	private static Fachada fachada;

	private IBusinessCliente businessCliente;
	private IBusinessEndereco businessEndereco;
	private IBusinessFuncionario businessFuncionario;
	private IBusinessCidade businessCidade;
	private IBusinessAtendimento businessAtendimento;
	private IBusinessConcentrador businessConcentrador;
	private IBusinessContato businessContato;
	private IBusinessContrato businessContrato;
	private IBusinessPorta businessPorta;
	private IBusinessServico businessServico;
	private IBusinessSwitch businessSwitch;
	private IBusinessCaixa businessCaixa;

	public Fachada() {
		businessCliente = new BusinessCliente();
		businessEndereco = new BusinessEndereco();
		businessFuncionario = new BusinessFuncionario();
		businessCidade = new BusinessCidade();
		businessAtendimento = new BusinessAtendimento();
		businessCaixa = new BusinessCaixa();
		businessConcentrador = new BusinessConcentrador();
		businessContato = new BusinessContato();
		businessContrato = new BusinessContrato();
		businessPorta = new BusinessPorta();
		businessServico = new BusinessServico();
		businessSwitch = new BusinessSwitch();
	}

	public static Fachada getInstance() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	// CLIENTE
	@Override
	public void salvarOuEditarCliente(Cliente cliente) throws BusinessException {
		this.businessCliente.salvarOuEditarCliente(cliente);

	}

	@Override
	public Cliente buscarClientePorId(int id) throws BusinessException {

		return this.buscarClientePorId(id);
	}

	@Override
	public Cliente buscarClientePorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> buscarClientePorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// ENDERECO

	@Override
	public void salvarOuEditarEndereco(Endereco endereco) throws BusinessException {
		businessEndereco.salvarOuEditarEndereco(endereco);

	}

	@Override
	public Endereco buscarEnderecoPorId(int id) throws BusinessException {
		return businessEndereco.buscarPorId(id);
	}

	@Override
	public ArrayList<Endereco> buscarEnderecoPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// FUNCIONARIO

	@Override
	public void salvarOuEditarFuncionario(Funcionario funcionario) throws BusinessException {
		businessFuncionario.salvarOuEditarFuncionario(funcionario);

	}

	@Override
	public Funcionario buscarFuncionarioPorId(int id)throws BusinessException {
		return businessFuncionario.buscarPorId(id);
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Funcionario> listarTodosFuncionarios() throws BusinessException {
		return businessFuncionario.listarTodos();
	}



	// CIDADE

	@Override
	public void salvarOuEditarCidade(Cidade cidade) throws BusinessException {
		businessCidade.salvarOuEditarCidade(cidade);

	}

	@Override
	public Cidade buscarCidadePorId(int id) throws BusinessException {
		return businessCidade.buscarPorId(id);
	}

	@Override
	public ArrayList<Cidade> buscarCidadePorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cidade> listarTodosCidades() throws BusinessException {
		return businessCidade.listarTodos();
	}

	// ATENDIMENTO
	@Override
	public void salvarOuEditarAtendimento(Atendimento atendimento, String cpfCliente) throws BusinessException {
		businessAtendimento.salvarOuEditar(atendimento, cpfCliente);

	}

	@Override
	public ArrayList<Atendimento> listarTodosAtendimento() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atendimento buscarAtendimentoPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Atendimento> buscarAtendimentoPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// CAIXA
	@Override
	public void salvarOuEditarCaixa(Caixa caixa, String cep) throws BusinessException {
		businessCaixa.salvarOuEditar(caixa, cep);

	}

	@Override
	public ArrayList<Caixa> listarTodosCaixa() throws BusinessException {
		
		return businessCaixa.listarTodos();
	}

	@Override
	public Caixa buscarCaixaPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Caixa> buscarCaixaPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// CONTATO

	@Override
	public void salvarOuEditarContato(Contato contato, String cpfCliente) throws BusinessException {
		businessContato.salvarOuEditar(contato, cpfCliente);

	}

	@Override
	public ArrayList<Contato> listarTodosContato() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contato buscarContatoPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contato> buscarContatoPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// CONTRATO
	@Override
	public void salvarOuEditarContrato(Contrato contrato, String cpfCliente, int numeroPorta) throws BusinessException {
		businessContrato.salvarOuEditar(contrato, cpfCliente, numeroPorta);

	}

	@Override
	public ArrayList<Contrato> listarTodosContrato() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrato buscarContratoPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contrato> buscarContratoPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// PORTA
	@Override
	public void salvarOuEditarPorta(Porta porta, String nomeSwitch) throws BusinessException {
		businessPorta.salvarOuEditar(porta, nomeSwitch);

	}

	@Override
	public ArrayList<Porta> listarTodosPorta() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Porta buscarPortaPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Porta> buscarPortaPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// SERVICO
	@Override
	public void salvarOuEditarServico(Servico servico) throws BusinessException {
		businessServico.salvarOuEditar(servico);

	}

	@Override
	public ArrayList<Servico> listarTodosServico() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servico buscarServicoPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Servico> buscarServicoPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// SWITCH
	@Override
	public void salvarOuEditarSwitch(Switch switch1, String nomeCaixa, String nomeConcentrador) throws BusinessException {
		businessSwitch.salvarOuEditar(switch1, nomeCaixa, nomeConcentrador);

	}

	@Override
	public ArrayList<Switch> listarTodosSwitch() throws BusinessException {
		// TODO Auto-generated method stub
		return businessSwitch.listarTodos();
	}

	@Override
	public Switch buscarvPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Switch> buscarSwitchPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	// CONCENTRADOR
	@Override
	public void salvarOuEditarConcentrador(Concentrador concentrador, String cep) throws BusinessException {
		businessConcentrador.salvarOuEditar(concentrador, cep);

	}

	@Override
	public ArrayList<Concentrador> listarTodosConcentrador() throws BusinessException {
		return businessConcentrador.listarTodos();
	}

	@Override
	public Concentrador buscarConcentradorPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Concentrador> buscarConcentradorPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

}
