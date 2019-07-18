package la.foton.treinamento.desafio.autorizador.log.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import la.foton.treinamento.desafio.autorizador.common.exception.Mensagem;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.log.dao.LogDAO;
import la.foton.treinamento.desafio.autorizador.log.entity.Log;

@Stateless
public class LogService {

	@Inject
	private LogDAO dao;

	public void gravaLog(Log log) throws NegocioException {
		if (log == null) {
			throw new NegocioException(Mensagem.LOG_INVALIDO);
		}

		dao.insere(log);
	}

}
