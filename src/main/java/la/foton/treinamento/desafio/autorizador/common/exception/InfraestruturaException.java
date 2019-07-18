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
package la.foton.treinamento.desafio.autorizador.common.exception;

public class InfraestruturaException extends Exception {

	private static final long serialVersionUID = 1L;

	private final Mensagem mensagem;

	public InfraestruturaException(Mensagem mensagem) {
		super(mensagem.getTexto());
		this.mensagem = mensagem;
	}

	public Mensagem getMensagem() {
		return this.mensagem;
	}

}