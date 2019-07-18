package la.foton.treinamento.desafio.autorizador.conta.dao;

import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;

import java.util.Optional;

public interface ContaDAO {

    void insere(Conta conta);

    void atualiza(Conta conta);

    Optional<Conta> procuraPorAgenciaENumero(Integer agencia, Integer numero);
}
