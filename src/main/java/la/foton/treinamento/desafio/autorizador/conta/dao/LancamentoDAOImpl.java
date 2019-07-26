package la.foton.treinamento.desafio.autorizador.conta.dao;

import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.LancamentoDaConta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LancamentoDAOImpl implements LancamentoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insere(LancamentoDaConta lancamentoDaConta) {
        em.persist(lancamentoDaConta);
    }

    @Override
    public List<LancamentoDaConta> consulta(Conta conta) {
        //em.find(conta);
        return null;
    }

}
