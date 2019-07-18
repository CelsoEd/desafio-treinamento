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

	DEPOSITO_EM_CONTA(10, "Depósito em Conta", TipoDoLancamento.CREDITO), //
	SAQUE_EM_CONTA(20, "Saque em Conta", TipoDoLancamento.DEBITO), //
	TRANSFERENCIA_ENTRE_CONTAS(30, "Transferência entre Contas", TipoDoLancamento.DEBITO), //
	INVESTIMENTO_EM_FUNDO(40, "Investimento em Fundo", TipoDoLancamento.CREDITO), //
	DOC_TED(50, "DOC/TED entre Bancos", TipoDoLancamento.DEBITO), //
	EXTRATO(60, "Extrato da Conta", null);

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