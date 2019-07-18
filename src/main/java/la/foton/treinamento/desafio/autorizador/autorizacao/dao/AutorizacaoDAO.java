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
package la.foton.treinamento.desafio.autorizador.autorizacao.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import la.foton.treinamento.desafio.autorizador.autorizacao.entity.Autorizacao;

public class AutorizacaoDAO {

	@PersistenceContext
	private EntityManager em;

	public void insere(Autorizacao autorizacao) {
		em.persist(autorizacao);
	}

}