package la.foton.treinamento.desafio.autorizador.log.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import la.foton.treinamento.desafio.autorizador.log.entity.Log;

public class LogDAO {

	@PersistenceContext
	private EntityManager em;

	public void insere(Log log) {
		em.persist(log);
	}

}