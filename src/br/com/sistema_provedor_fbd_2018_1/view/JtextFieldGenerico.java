package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public final class JtextFieldGenerico extends JTextField {
	private int maximoCaracteres = -1;// defini��o de -1
	private String caracteres;
	// como valor normal de um textfield sem limite de caracters

	public JtextFieldGenerico(String carc) {
		super();
		this.caracteres = carc;
		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	public void JtextFieldSomenteLetras(int maximo, String caracteres) {
		this.caracteres = caracteres;
		setMaximoCaracteres(maximo);// define o tamanho m�ximo
		// que deve ser aceito no jtextfield que foi recebido no construtor

		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	private void jTextFieldKeyTyped(KeyEvent evt) {

		
		if (!caracteres.contains(evt.getKeyChar() + "")) {// se o caracter que gerou o evento estiver n�o estiver na
															// lista
			evt.consume();// aciona esse propriedade para eliminar a a��o do evento
		}
		if ((getText().length() >= getMaximoCaracteres()) && (getMaximoCaracteres() != -1)) {
			// if para saber se precisa verificar tamb�m o tamanho da string do campo
			// maior ou igual ao tamanho m�ximo, cancela e nao deixa inserir mais
			evt.consume();
			setText(getText().substring(0, getMaximoCaracteres()));
			// esta linha acima � para remover os caracters inv�lidos caso o usu�rio tenha
			// copiado o //conte�do de algum lugar, ou seja, com tamanho maior que o
			// definido
		} // fim do if do tamanho da string do campo

	}

	public int getMaximoCaracteres() {
		return maximoCaracteres;
	}

	public void setMaximoCaracteres(int maximoCaracteres) {
		this.maximoCaracteres = maximoCaracteres;
	}
}