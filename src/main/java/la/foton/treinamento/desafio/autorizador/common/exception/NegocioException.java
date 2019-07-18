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

import javax.ws.rs.core.Response;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	private final Mensagem mensagem;
	private Response.Status status;

	public NegocioException(Mensagem mensagem) {
		super(mensagem.getTexto());
		this.mensagem = mensagem;
	}

	public NegocioException(Mensagem mensagem, Response.Status status) {
		this(mensagem);
		this.status = status;
	}

	public Mensagem getMensagem() {
		return this.mensagem;
	}

	public Response.Status getStatus() {
		return status;
	}
}
