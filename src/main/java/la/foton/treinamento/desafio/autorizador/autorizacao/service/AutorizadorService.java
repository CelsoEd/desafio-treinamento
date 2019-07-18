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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import la.foton.treinamento.desafio.autorizador.autorizacao.dao.AutorizacaoDAO;
import la.foton.treinamento.desafio.autorizador.autorizacao.entity.Autorizacao;
import la.foton.treinamento.desafio.autorizador.autorizacao.entity.EstadoDaAutorizacao;
import la.foton.treinamento.desafio.autorizador.common.exception.InfraestruturaException;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.log.service.LogService;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;

@Stateless
public class AutorizadorService {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@EJB
	private AutorizadorFactory factory;

	@Inject
	private AutorizacaoDAO dao;

	@EJB
	private LogService logService;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Autorizacao executa(Transacao transacao) {
		Autorizacao autorizacao = new Autorizacao();

		AbstractAutorizador autorizador;
		try {
			autorizador = factory.criaAutorizador(transacao);

			autorizacao = autorizador.executa(transacao);

			dao.insere(autorizacao);

			if (EstadoDaAutorizacao.AUTORIZADA.equals(autorizacao.getEstado())) {
				logService.gravaLog(autorizador.criaLog(autorizacao));
			}
		} catch (NegocioException ne) {
			autorizacao.setMotivoDaNegacao(ne.getMensagem().getTexto());
		} catch (InfraestruturaException ie) {
			autorizacao.setMotivoDaNegacao(ie.getMensagem().getTexto());
		} catch (Exception e) {
			logger.log(Level.SEVERE, "ERRO INTERNO: ", e);
			autorizacao.negada();
			autorizacao.setMotivoDaNegacao("Problema interno, contate o administrador");
		}

		return autorizacao;
	}

}
