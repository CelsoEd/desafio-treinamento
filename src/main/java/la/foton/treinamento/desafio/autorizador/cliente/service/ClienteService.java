package la.foton.treinamento.desafio.autorizador.cliente.service;

import la.foton.treinamento.desafio.autorizador.cliente.dao.ClienteDAO;
import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;
import la.foton.treinamento.desafio.autorizador.common.exception.Mensagem;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class ClienteService {

    @Inject
    private ClienteDAO clienteDAO;

    public Cliente novoCliente(Cliente cliente) {
        clienteDAO.insere(cliente);
        return cliente;
    }

    public void ativaCliente(String cpf) throws NegocioException {
        Cliente cliente = consultaCliente(cpf);
        cliente.ativa();
        clienteDAO.atualiza(cliente);
    }

    public Cliente consultaCliente(String cpf) throws NegocioException {
        return clienteDAO.procurarPeloCpf(cpf)
                .orElseThrow(() -> new NegocioException(Mensagem.CLIENTE_NAO_ENCONTRADO, Response.Status.NOT_FOUND));
    }
}
