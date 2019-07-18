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
import la.foton.treinamento.desafio.autorizador.transacao.entity.TransacaoDeTransferencia;

import javax.ejb.EJB;

@Autorizador(transacao = TipoDaTransacao.TRANSFERENCIA_ENTRE_CONTAS)
public class AutorizadorTransferencia extends AbstractAutorizador {

    @EJB
    private ContaService contaService;

    @Override
    protected void executaRegrasEspecificas(Transacao transacao) throws NegocioException {
        TransacaoDeTransferencia transacaoDeTransferencia = (TransacaoDeTransferencia) transacao;
        Conta conta = contaService.consultaContaPorAgenciaENumero(transacaoDeTransferencia.getAgencia(), transacaoDeTransferencia.getConta());
        Conta contaFavorecido = contaService.consultaContaPorAgenciaENumero(transacaoDeTransferencia.getAgenciaFavorecido(),
                transacaoDeTransferencia.getContaFavorecido());
        conta.transfere(transacaoDeTransferencia.getValor(), contaFavorecido);
        contaService.geraLancamento(conta, transacaoDeTransferencia.getValor(), TipoDoLancamento.DEBITO, "Transferêcia entre contas");
        contaService.geraLancamento(contaFavorecido, transacaoDeTransferencia.getValor(), TipoDoLancamento.CREDITO, "Transferêcia entre contas");
        contaService.atualizaConta(conta);
        contaService.atualizaConta(contaFavorecido);
    }

    @Override
    protected Log criaLog(Autorizacao autorizacao) throws NegocioException {
        Log log = new Log();
        log.setAgencia(autorizacao.getAgenciaOrigem());
        log.setCanal(autorizacao.getCanal());
        log.setDataRefencia(autorizacao.getDataReferencia());
        log.setTipoDaTransacao(autorizacao.getTipoDaTransacao());
        log.setParticao(autorizacao.getTransacao());
        return log;
    }

}
