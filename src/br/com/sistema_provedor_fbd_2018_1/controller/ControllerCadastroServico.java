package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;

import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalCadastroServico;
import br.com.sistema_provedor_fbd_2018_1.view.InternalServicos;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerCadastroServico implements Listeners {
	private InternalCadastroServico internalCadastroServico;
	private Fachada fachada;
	private InternalServicos internalServicos;

	public ControllerCadastroServico(InternalServicos internalServicos) {
		fachada = new Fachada();
		this.internalServicos = internalServicos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == internalCadastroServico.getBtnInserirServio()) {

			try {
				Servico servico = new Servico(internalCadastroServico.getServicoField().getText(),
						Integer.parseInt(internalCadastroServico.getUploadField().getText().trim()),
						Integer.parseInt(internalCadastroServico.getDownloadField().getText().trim()));
				fachada.salvarOuEditarServico(servico);
				internalServicos.carregarServicos(fachada.listarTodosServico());
				Menssagens.menssagem("Servi�o Inserido com sucesso.", 1);
				
				internalCadastroServico.getServicoField().setText("");
				internalCadastroServico.getDownloadField().setText("");
				internalCadastroServico.getUploadField().setText("");
				
				
			} catch (BusinessException e1) {
				e1.getMessage();
			}

		}

	}

	@Override
	public void addListeners() {
		internalCadastroServico.getBtnInserirServio().addActionListener(this);

	}

	public InternalCadastroServico getInternalCadastroServico() {
		return internalCadastroServico;
	}

	public void setInternalCadastroServico(InternalCadastroServico internalCadastroServico) {
		this.internalCadastroServico = internalCadastroServico;
	}

}
