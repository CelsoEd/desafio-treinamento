package la.foton.treinamento.desafio.autorizador.cliente.dao;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl implements ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insere(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void atualiza(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public Optional<Cliente> procurarPeloCpf(String cpf) {
        return Optional.ofNullable(em.find(Cliente.class, cpf));
    }

    @Override
    public List<Cliente> listarTodos() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

}
