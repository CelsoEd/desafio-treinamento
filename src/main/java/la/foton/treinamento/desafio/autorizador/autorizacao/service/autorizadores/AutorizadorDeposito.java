package la.foton.treinamento.desafio.autorizador.autorizacao.service.autorizadores;

import la.foton.treinamento.desafio.autorizador.autorizacao.entity.Autorizacao;
import la.foton.treinamento.desafio.autorizador.autorizacao.service.AbstractAutorizador;
import la.foton.treinamento.desafio.autorizador.autorizacao.service.Autorizador;
import la.foton.treinamento.desafio.autorizador.common.configuration.JSONConverter;
import la.foton.treinamento.desafio.autorizador.common.exception.InfraestruturaException;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoLancamento;
import la.foton.treinamento.desafio.autorizador.conta.service.ContaService;
import la.foton.treinamento.desafio.autorizador.log.entity.Log;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TipoDaTransacao;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TransacaoFinanceira;

import javax.ejb.EJB;

@Autorizador(transacao = TipoDaTransacao.DEPOSITO)
public class AutorizadorDeposito extends AbstractAutorizador {

    @EJB
    private ContaService contaService;

    @Override
    protected void executaRegrasEspecificas(Transacao transacao, Autorizacao autorizacao) throws NegocioException {
        Conta conta = contaService.consultaContaPorAgenciaENumero(transacao.getAgencia(), transacao.getConta());
        conta.credita(((TransacaoFinanceira)transacao).getValor());
        contaService.geraLancamento(conta, ((TransacaoFinanceira)transacao).getValor(), TipoDoLancamento.CREDITO, TipoDoLancamento.CREDITO.getValor());
        contaService.atualizaConta(conta);
    }

    @Override
    protected Log criaLog(Autorizacao autorizacao) throws NegocioException, InfraestruturaException {
        Log log = new Log();
        log.setAgencia(autorizacao.getAgenciaOrigem());
        log.setCanal(autorizacao.getCanal());
        log.setDataRefencia(autorizacao.getDataReferencia());
        log.setTipoDaTransacao(autorizacao.getTipoDaTransacao());
        log.setParticao(JSONConverter.toJSONFromObject(autorizacao));
        return log;
    }
}
