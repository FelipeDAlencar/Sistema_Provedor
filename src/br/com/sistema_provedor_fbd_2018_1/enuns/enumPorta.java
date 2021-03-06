package br.com.sistema_provedor_fbd_2018_1.enuns;
public enum enumPorta{
	OCUPADA("ocupada"), LIVRE("livre"), DANIFICADA("danificada");
	private final String status;
	private enumPorta(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static enumPorta getEnum(String status) {
		switch (status) {
		case "ocupada":
			return OCUPADA;
		case "livre":
			return LIVRE;
		case "danificada":
			return DANIFICADA;
		default:
			return null;
		}
	}
}