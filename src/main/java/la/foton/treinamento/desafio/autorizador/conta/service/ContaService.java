package la.foton.treinamento.desafio.autorizador.conta.service;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;
import la.foton.treinamento.desafio.autorizador.cliente.service.ClienteService;
import la.foton.treinamento.desafio.autorizador.common.exception.Mensagem;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.conta.dao.ContaDAO;
import la.foton.treinamento.desafio.autorizador.conta.dao.LancamentoDAO;
import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.LancamentoDaConta;
import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoLancamento;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class ContaService {

    @Inject
    private ContaDAO contaDAO;

    @Inject
    private LancamentoDAO lancamentoDAO;

    @EJB
    private ClienteService clienteService;

    public Conta novaConta(Conta conta, String cpf) throws NegocioException {
        Cliente cliente = clienteService.consultaCliente(cpf);
        conta.setTitular(cliente);
        contaDAO.insere(conta);
        return conta;
    }

    public Conta consultaContaPorAgenciaENumero(Integer agencia, Integer numero) throws NegocioException {
        return contaDAO.procuraPorAgenciaENumero(agencia, numero)
                .orElseThrow(() -> new NegocioException(Mensagem.CONTA_NAO_ENCONTRADA, Response.Status.NOT_FOUND));
    }

    public void atualizaConta(Conta conta) {
        contaDAO.atualiza(conta);
    }

    public void geraLancamento(Conta conta, BigDecimal valor, TipoDoLancamento tipoDoLancamento, String descricao) {
        LancamentoDaConta lancamentoDaConta = new LancamentoDaConta(tipoDoLancamento, descricao, valor, conta);
        lancamentoDAO.insere(lancamentoDaConta);
    }

    public List<LancamentoDaConta> consultaLancamento(Conta conta){
        return conta.getLancamentos();
    }

}
