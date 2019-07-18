package la.foton.treinamento.desafio.autorizador.conta.dao;

import la.foton.treinamento.desafio.autorizador.conta.entity.LancamentoDaConta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LancamentoDAOImpl implements LancamentoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insere(LancamentoDaConta lancamentoDaConta) {
        em.persist(lancamentoDaConta);
    }

}
