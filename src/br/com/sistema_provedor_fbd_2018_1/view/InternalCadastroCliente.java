package br.com.sistema_provedor_fbd_2018_1.view;


import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import javax.swing.JButton;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class InternalCadastroCliente extends TelaInternal {
	private JTabbedPane tabbedPane;
	private JPanel panelCliente;
	private PanelContato panelContatos;
	private JLabel nomeLabel, cpfLabel, rgLabel, dataNascimentoLabel;
	private JLabel bairroLabel, complementoLabel, ruaLabel, numeroLabel;
	private JLabel cidadeLabel;
	private JTextField nomeField, rgField;
	private JTextField bairroField, complementoField, ruaField;
	private JtextFieldGenerico numeroField;
	private JComboBox<String> cidadesComboBox;
	private JComboBox<String> comboContato;
	private Botao bntSalvar;
	private JFormattedTextField cpfField, dataNascimentoField;
	private JLabel lblTipo;
	private JtextFieldGenerico contatoField;
	private JButton btnNovoContato;
	private JLabel lblResponsvel;
	private JTextField responsavelField;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblContato_1;
	private JTextField emailField;

	public InternalCadastroCliente(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Adicionar Cliente", telaPrincipal, actionListener);
		getContentPane().setLayout(null);
	}

	@Override
	public void inicializar() throws BusinessException {
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, TelaInternal.LARGURA - 100, TelaInternal.ALTURA - 350);

		panelContatos = new PanelContato();

		panelCliente = new JPanel();
		panelCliente.setLayout(null);

		bntSalvar = new Botao("resource/imagens/botoes/bnt-salvar.png", "Salvar");
		bntSalvar.setBounds(1090, 429, 100, 40);

		// Informacoes Cliente
		nomeLabel = new JLabel("Nome Completo:");
		nomeLabel.setBounds(47, 29, 100, 50);
		panelCliente.add(nomeLabel);

		nomeField = new JTextField();
		nomeField.setBounds(47, 76, 450, 30);
		panelCliente.add(nomeField);

		cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(567, 29, 100, 50);
		panelCliente.add(cpfLabel);

		cpfField = new JFormattedTextField();
		cpfField.setBounds(567, 76, 230, 30);
		panelCliente.add(cpfField);

		rgLabel = new JLabel("RG:");
		rgLabel.setBounds(865, 29, 100, 50);
		panelCliente.add(rgLabel);

		rgField = new JTextField();
		rgField.setBounds(865, 76, 200, 30);
		panelCliente.add(rgField);

		dataNascimentoLabel = new JLabel("Data de Nascimento:");
		dataNascimentoLabel.setBounds(47, 125, 200, 50);
		panelCliente.add(dataNascimentoLabel);

		dataNascimentoField = new JFormattedTextField();
		dataNascimentoField.setBounds(47, 176, 150, 30);
		panelCliente.add(dataNascimentoField);

		// Informacoes Endereco
		ruaLabel = new JLabel("Endere�o:");
		ruaLabel.setBounds(277, 125, 100, 50);
		panelCliente.add(ruaLabel);

		ruaField = new JTextField();
		ruaField.setBounds(277, 176, 420, 30);
		panelCliente.add(ruaField);

		numeroLabel = new JLabel("N�mero:");
		numeroLabel.setBounds(749, 125, 100, 50);
		panelCliente.add(numeroLabel);

		numeroField = new JtextFieldGenerico("1234567890");
		numeroField.setBounds(749, 176, 60, 30);
		panelCliente.add(numeroField);

		complementoLabel = new JLabel("Complemento:");
		complementoLabel.setBounds(865, 125, 100, 50);
		panelCliente.add(complementoLabel);

		complementoField = new JTextField();
		complementoField.setBounds(865, 176, 200, 30);
		panelCliente.add(complementoField);

		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setBounds(47, 217, 100, 50);
		panelCliente.add(bairroLabel);

		bairroField = new JTextField();
		bairroField.setBounds(47, 266, 180, 30);
		panelCliente.add(bairroField);

		// Informa�oes de Cidade
		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setBounds(277, 217, 100, 50);
		panelCliente.add(cidadeLabel);

		carregarCidades();
		cidadesComboBox.setBounds(277, 266, 200, 30);
		panelCliente.add(cidadesComboBox);
		

		tabbedPane.add("Novo Cliente", panelCliente);
		tabbedPane.add("Contatos", panelContatos);
				
		getContentPane().add(tabbedPane);
		getContentPane().add(bntSalvar);
		

		
		try {
			dataNascimentoField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			cpfField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
	
				
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	
	private void carregarCidades() throws BusinessException {
		List<Cidade> cidadesList = new ArrayList<>();
		cidadesComboBox = new JComboBox<>();
		Fachada fachada = new Fachada();
		cidadesList = fachada.listarTodosCidades();
		for (Cidade cidade : cidadesList) {
			cidadesComboBox.addItem(cidade.getNome()+" - "+ cidade.getEstado());
		}
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JPanel getPanelCliente() {
		return panelCliente;
	}

	public void setPanelCliente(JPanel panelCliente) {
		this.panelCliente = panelCliente;
	}

	public PanelContato getPanelContatos() {
		return panelContatos;
	}

	public void setPanelContatos(PanelContato panelContatos) {
		this.panelContatos = panelContatos;
	}

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	public JLabel getCpfLabel() {
		return cpfLabel;
	}

	public void setCpfLabel(JLabel cpfLabel) {
		this.cpfLabel = cpfLabel;
	}

	public JLabel getRgLabel() {
		return rgLabel;
	}

	public void setRgLabel(JLabel rgLabel) {
		this.rgLabel = rgLabel;
	}

	public JLabel getDataNascimentoLabel() {
		return dataNascimentoLabel;
	}

	public void setDataNascimentoLabel(JLabel dataNascimentoLabel) {
		this.dataNascimentoLabel = dataNascimentoLabel;
	}

	public JLabel getBairroLabel() {
		return bairroLabel;
	}

	public void setBairroLabel(JLabel bairroLabel) {
		this.bairroLabel = bairroLabel;
	}

	public JLabel getComplementoLabel() {
		return complementoLabel;
	}

	public void setComplementoLabel(JLabel complementoLabel) {
		this.complementoLabel = complementoLabel;
	}

	public JLabel getRuaLabel() {
		return ruaLabel;
	}

	public void setRuaLabel(JLabel ruaLabel) {
		this.ruaLabel = ruaLabel;
	}

	public JLabel getNumeroLabel() {
		return numeroLabel;
	}

	public void setNumeroLabel(JLabel numeroLabel) {
		this.numeroLabel = numeroLabel;
	}

	public JLabel getCidadeLabel() {
		return cidadeLabel;
	}

	public void setCidadeLabel(JLabel cidadeLabel) {
		this.cidadeLabel = cidadeLabel;
	}

	
	

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JFormattedTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTextField getRgField() {
		return rgField;
	}

	public void setRgField(JTextField rgField) {
		this.rgField = rgField;
	}

	public JTextField getDataNascimentoField() {
		return dataNascimentoField;
	}

	public void setDataNascimentoField(JFormattedTextField dataNascimentoField) {
		this.dataNascimentoField = dataNascimentoField;
	}

	public JTextField getBairroField() {
		return bairroField;
	}

	public void setBairroField(JTextField bairroField) {
		this.bairroField = bairroField;
	}

	public JTextField getComplementoField() {
		return complementoField;
	}

	public void setComplementoField(JTextField complementoField) {
		this.complementoField = complementoField;
	}

	public JTextField getRuaField() {
		return ruaField;
	}

	public void setRuaField(JTextField ruaField) {
		this.ruaField = ruaField;
	}

	public JTextField getNumeroField() {
		return numeroField;
	}


	public JComboBox<String> getCidadesComboBox() {
		return cidadesComboBox;
	}

	public void setCidadesComboBox(JComboBox<String> cidadesComboBox) {
		this.cidadesComboBox = cidadesComboBox;
	}

	

	public Botao getBtnSalvar() {
		return bntSalvar;
	}

	public void setBntSalvar(Botao bntSalvar) {
		this.bntSalvar = bntSalvar;
	}

	public JComboBox<String> getComboContato() {
		return comboContato;
	}

	public Botao getBntSalvar() {
		return bntSalvar;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JtextFieldGenerico getContatoField() {
		return contatoField;
	}

	public JButton getBtnNovoContato() {
		return btnNovoContato;
	}

	public JLabel getLblResponsvel() {
		return lblResponsvel;
	}

	public JTextField getResponsavelField() {
		return responsavelField;
	}

	public JSeparator getSeparator_1() {
		return separator_1;
	}

	public JSeparator getSeparator_2() {
		return separator_2;
	}

	public JLabel getLblContato_1() {
		return lblContato_1;
	}

	public JTextField getEmailField() {
		return emailField;
	}
	
	
	
}
