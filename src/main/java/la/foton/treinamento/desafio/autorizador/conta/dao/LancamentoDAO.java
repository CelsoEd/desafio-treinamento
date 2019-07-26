package la.foton.treinamento.desafio.autorizador.conta.dao;

import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.LancamentoDaConta;

import java.util.List;

public interface LancamentoDAO {

    void insere(LancamentoDaConta lancamentoDaConta);

    List<LancamentoDaConta> consulta (Conta conta);

}
