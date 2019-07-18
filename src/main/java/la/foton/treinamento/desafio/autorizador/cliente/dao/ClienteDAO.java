package la.foton.treinamento.desafio.autorizador.cliente.dao;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;

import java.util.Optional;

public interface ClienteDAO {

    void insere(Cliente cliente);

    void atualiza(Cliente cliente);

    Optional<Cliente> procurarPeloCpf(String cpf);
}
