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

import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoLancamento;

public enum TipoDaTransacao {

	DEPOSITO(10, "Depósito em Conta", TipoDoLancamento.CREDITO), //
	SAQUE(20, "Saque em Conta", TipoDoLancamento.DEBITO), //
	TRANSFERENCIA(30, "Transferência entre Contas", TipoDoLancamento.DEBITO), //
	EXTRATO(40, "Extrato da Conta", TipoDoLancamento.NAO_APLICAVEL),
	SALDO(50, "Saldo da conta", TipoDoLancamento.NAO_APLICAVEL); //


	private Integer chave;
	private String valor;
	private TipoDoLancamento tipoDoLancamento;

	private TipoDaTransacao(Integer chave, String valor, TipoDoLancamento tipoDoLancamento) {
		this.chave = chave;
		this.valor = valor;
		this.tipoDoLancamento = tipoDoLancamento;
	}

	public Integer getChave() {
		return chave;
	}

	public String getValor() {
		return valor;
	}

	public TipoDoLancamento getTipoDoLancamento() {
		return tipoDoLancamento;
	}

	public static TipoDaTransacao get(String valor) {
		for (TipoDaTransacao tipoDaTransacao : TipoDaTransacao.values()) {
			if (valor.equals(tipoDaTransacao.getValor())) {
				return tipoDaTransacao;
			}
		}

		return null;
	}
}
