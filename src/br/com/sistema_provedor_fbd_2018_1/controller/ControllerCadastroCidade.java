package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroCidade;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCidade;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroCidade implements Listeners {

	private InternalCadastroCidade internalCadastroCidade;
	private InternalCidade internalCidade;
	private Fachada fachada;

	public ControllerCadastroCidade(InternalCidade internalCidade) {
		fachada = new Fachada();
		this.internalCidade = internalCidade;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == internalCadastroCidade.getBtnAdd()) {
			try {
				Cidade cidade = new Cidade(internalCadastroCidade.getNomeField().getText(),
						internalCadastroCidade.getEstadoField().getText().toUpperCase(),
						internalCadastroCidade.getCepField().getText(), true);

				fachada.salvarOuEditarCidade(cidade);
				internalCidade.carregarCidades(fachada.listarTodosCidades());
				Menssagens.menssagem("Cidade salva com sucesso!", 1);
				internalCadastroCidade.getNomeField().setText("");
				internalCadastroCidade.getEstadoField().setText("");
				internalCadastroCidade.getCepField().setText("00000-000");
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}

		}
	}

	@Override
	public void addListeners() {
		internalCadastroCidade.getBtnAdd().addActionListener(this);

	}

	public InternalCadastroCidade getInternalCadastroCidade() {
		return internalCadastroCidade;
	}

	public void setInternalCadastroCidade(InternalCadastroCidade internalCadastroCidade) {
		this.internalCadastroCidade = internalCadastroCidade;
	}

}
