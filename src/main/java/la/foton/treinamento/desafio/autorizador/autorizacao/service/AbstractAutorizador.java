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
package la.foton.treinamento.desafio.autorizador.autorizacao.service;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;

import la.foton.treinamento.desafio.autorizador.autorizacao.entity.Autorizacao;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.log.entity.Log;
import la.foton.treinamento.desafio.autorizador.transacao.converter.TransacaoJSONConverter;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;

public abstract class AbstractAutorizador {

	@Inject
	private TransacaoJSONConverter<Transacao> converter;

	public Autorizacao executa(Transacao transacao) {
		Autorizacao autorizacao = new Autorizacao();

		try {
			String json = converter.toJSONFromTransacao(transacao);
			autorizacao.setTransacao(json);

			autorizacao.setNsuOrigem(transacao.getNsuOrigem());
			autorizacao.setCanal(transacao.getCanal());
			autorizacao.setAgenciaOrigem(transacao.getAgencia());
			autorizacao.setTipoDaTransacao(transacao.getTipo());

			executaRegrasEspecificas(transacao);
			autorizacao.autorizada();
		} catch (NegocioException ne) {
			autorizacao.negada();
			autorizacao.setMotivoDaNegacao(ne.getMensagem().getTexto());
		} catch (JsonProcessingException jpe) {
			autorizacao.negada();
			autorizacao.setMotivoDaNegacao("Problema com o formato da transação");
		}

		return autorizacao;
	}

	protected abstract void executaRegrasEspecificas(Transacao transacao) throws NegocioException;

	protected abstract Log criaLog(Autorizacao autorizacao) throws NegocioException;

}
