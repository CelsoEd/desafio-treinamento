package la.foton.treinamento.desafio.autorizador.autorizacao.service.autorizadores;

import la.foton.treinamento.desafio.autorizador.autorizacao.entity.Autorizacao;
import la.foton.treinamento.desafio.autorizador.autorizacao.service.AbstractAutorizador;
import la.foton.treinamento.desafio.autorizador.autorizacao.service.Autorizador;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoLancamento;
import la.foton.treinamento.desafio.autorizador.conta.service.ContaService;
import la.foton.treinamento.desafio.autorizador.log.entity.Log;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TipoDaTransacao;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TransacaoFinanceira;

import javax.ejb.EJB;

@Autorizador(transacao = TipoDaTransacao.SAQUE)
public class AutorizadorSaque extends AbstractAutorizador {

    @EJB
    private ContaService contaService;

    @Override
    protected void executaRegrasEspecificas(Transacao transacao , Autorizacao autorizacao) throws NegocioException {
        Conta conta = contaService.consultaContaPorAgenciaENumero(transacao.getAgencia(), transacao.getConta());
        conta.debita(((TransacaoFinanceira)transacao).getValor());
        contaService.geraLancamento(conta, ((TransacaoFinanceira)transacao).getValor(), TipoDoLancamento.DEBITO, TipoDaTransacao.SAQUE.getValor());
        contaService.atualizaConta(conta);
    }
}
