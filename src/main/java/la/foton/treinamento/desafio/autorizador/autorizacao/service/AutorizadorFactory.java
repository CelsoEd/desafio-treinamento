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

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import la.foton.treinamento.desafio.autorizador.common.exception.InfraestruturaException;
import la.foton.treinamento.desafio.autorizador.common.exception.Mensagem;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;

@Singleton
@Startup
public class AutorizadorFactory {

	@Inject
	@Any
	private Instance<AbstractAutorizador> instancias;

	public AbstractAutorizador criaAutorizador(Transacao transacao) throws InfraestruturaException {
		for (AbstractAutorizador instancia : instancias) {
			Autorizador anotacao = instancia.getClass().getAnnotation(Autorizador.class);

			if (anotacao != null && anotacao.transacao() != null && anotacao.transacao().equals(transacao.getTipo())) {
				return instancia;
			}
		}

		throw new InfraestruturaException(Mensagem.AUTORIZADOR_NAO_ENCONTRADO);
	}

}
