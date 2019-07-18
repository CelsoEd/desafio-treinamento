package la.foton.treinamento.desafio.autorizador.conta.entity;

public enum TipoDoPacoteDeServicos {

	BASICO(1, "Básico"), ESPECIAL(2, "Especial");

	private Integer chave;
	private String valor;

	private TipoDoPacoteDeServicos(Integer chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public Integer getChave() {
		return chave;
	}

	public String getValor() {
		return valor;
	}
}
