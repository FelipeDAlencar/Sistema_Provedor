package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class InternalCadastroFuncionario extends TelaInternal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeFild;
	private JTextField LoginFild;
	private JPasswordField senhaField;
	private JTextField ruaFild;
	private JTextField bairroFild,cargoField;
	private JTextField numeroFild;
	private JTextField complementoFild;
	private JComboBox<String> cidadesCombo;
	private JTextField cepFild;
	private JFormattedTextField data_contratoFild, estadoFild;
	private JButton btnAdicionar;

	public InternalCadastroFuncionario(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Cadastro de Funcion�rios", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);

		

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome Completo:");
		lblNome.setBounds(55, 64, 105, 14);
		getContentPane().add(lblNome);

		nomeFild = new JTextField();
		nomeFild.setBounds(55, 89, 365, 29);
		getContentPane().add(nomeFild);
		nomeFild.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(500, 64, 46, 14);
		getContentPane().add(lblCargo);

		JLabel lblNewLabel = new JLabel("Data de contrato:");
		lblNewLabel.setBounds(814, 64, 94, 14);
		getContentPane().add(lblNewLabel);

		data_contratoFild = new JFormattedTextField();
		data_contratoFild.setBounds(814, 89, 188, 29);
		getContentPane().add(data_contratoFild);
		data_contratoFild.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(55, 155, 46, 14);
		getContentPane().add(lblLogin);

		LoginFild = new JTextField();
		LoginFild.setToolTipText("Login");
		LoginFild.setBounds(55, 180, 141, 29);
		getContentPane().add(LoginFild);
		LoginFild.setColumns(10);

		cargoField = new JFormattedTextField();
		cargoField.setBounds(500, 89, 118, 29);
		getContentPane().add(cargoField);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(246, 155, 46, 14);
		getContentPane().add(lblSenha);

		senhaField = new JPasswordField();
		senhaField.setBounds(246, 180, 174, 29);
		getContentPane().add(senhaField);

		JLabel lblNewLabel_1 = new JLabel("Rua:");
		lblNewLabel_1.setBounds(500, 155, 46, 14);
		getContentPane().add(lblNewLabel_1);

		ruaFild = new JTextField();
		ruaFild.setBounds(500, 180, 229, 29);
		getContentPane().add(ruaFild);
		ruaFild.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(814, 155, 46, 14);
		getContentPane().add(lblBairro);

		bairroFild = new JTextField();
		bairroFild.setBounds(814, 180, 188, 29);
		getContentPane().add(bairroFild);
		bairroFild.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(55, 251, 69, 14);
		getContentPane().add(lblNumero);

		numeroFild = new JTextField();
		numeroFild.setBounds(55, 276, 86, 29);
		getContentPane().add(numeroFild);
		numeroFild.setColumns(10);

		JLabel lblComplemeto = new JLabel("Complemeto:");
		lblComplemeto.setBounds(246, 251, 79, 14);
		getContentPane().add(lblComplemeto);

		complementoFild = new JTextField();
		complementoFild.setBounds(246, 276, 248, 29);
		getContentPane().add(complementoFild);
		complementoFild.setColumns(10);

		carregarCidades();
		cidadesCombo.setBounds(532, 276, 126, 29);
		getContentPane().add(cidadesCombo);

		JLabel lblNewLabel_2 = new JLabel("Cidade:");
		lblNewLabel_2.setBounds(532, 251, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Estado:");
		lblNewLabel_3.setBounds(723, 251, 46, 14);
		getContentPane().add(lblNewLabel_3);

		estadoFild = new JFormattedTextField();
		estadoFild.setBounds(723, 276, 46, 29);
		getContentPane().add(estadoFild);

		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setBounds(814, 251, 46, 14);
		getContentPane().add(lblNewLabel_4);

		cepFild = new JTextField();
		cepFild.setBounds(814, 276, 188, 29);
		getContentPane().add(cepFild);
		cepFild.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(922, 366, 89, 29);
		getContentPane().add(btnAdicionar);

		try {
			estadoFild.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("AA")));
			data_contratoFild.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	private void carregarCidades() throws BusinessException {
		List<Cidade> cidadesList = new ArrayList<>();
		cidadesCombo = new JComboBox<>();
		Fachada fachada = new Fachada();
		cidadesList = fachada.listarTodosCidades();
		for (Cidade cidade : cidadesList) {
			cidadesCombo.addItem(cidade.getNome());
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getNomeFild() {
		return nomeFild;
	}

	public JTextField getLoginFild() {
		return LoginFild;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JTextField getRuaFild() {
		return ruaFild;
	}

	public JTextField getBairroFild() {
		return bairroFild;
	}

	public JTextField getNumeroFild() {
		return numeroFild;
	}

	public JTextField getComplementoFild() {
		return complementoFild;
	}

	public JComboBox<String> getCidadesCombo() {
		return cidadesCombo;
	}

	public JTextField getCepFild() {
		return cepFild;
	}

	public JFormattedTextField getData_contratoFild() {
		return data_contratoFild;
	}

	public JFormattedTextField getEstadoFild() {
		return estadoFild;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public JTextField getCargoField() {
		return cargoField;
	}
	
	
}