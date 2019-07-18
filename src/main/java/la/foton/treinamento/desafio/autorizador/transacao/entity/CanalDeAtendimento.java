/*
 * Foton Informática.
 * Autor: Flávio Roberto (flavio.silva@foton.la)
 *
 * Autorizador Bancário
 *
 * OBS: Todos os códigos estão sendo oferecidos com a intenção única de
 * estimular o aprendizado. Não podem ser usados com fins comerciais sem
 * autorização prévia do autor. Se redistribuídos para outros sites, o autor e
 * a fonte devem ser sempre citados.
 */
package la.foton.treinamento.desafio.autorizador.transacao.entity;

public enum CanalDeAtendimento {

	NEXTBANK(1, "Terminal de Caixa"), //
	NETBANKING(2, "Internet Banking"), //
	MYPHONE(3, "Mobile Banking"), //
	EXTRACASH(4, "ATM CashDispenser");

	private Integer chave;
	private String valor;

	private CanalDeAtendimento(Integer chave, String valor) {
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
