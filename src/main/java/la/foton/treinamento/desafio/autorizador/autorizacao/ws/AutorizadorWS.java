package la.foton.treinamento.desafio.autorizador.autorizacao.ws;

import la.foton.treinamento.desafio.autorizador.autorizacao.service.AutorizadorService;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TransacaoDeTransferencia;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TransacaoFinanceira;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("autorizador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AutorizadorWS extends AbstractAutorisadoResource{

    @EJB
    private AutorizadorService autorizadorService;


    @GET
    public Response teste(){
        String teste = "hellow";
        return  Response.ok(teste).build();
    }

    @POST
    @Path("deposito-saque")
    public Response autorizaDepositoSaque(TransacaoFinanceira transacaoFinanceira) {
        return Response.ok(autorizadorService.executa(transacaoFinanceira)).build();
    }

    @POST
    @Path("transferencia")
    public Response autorizaTransferencia(TransacaoDeTransferencia transacaoDeTransferencia) {
        return Response.ok(autorizadorService.executa(transacaoDeTransferencia)).build();
    }

    @POST
    @Path("lancamento-saldo")
    public Response autorizaSaldo(Transacao transacao){
        return Response.ok(autorizadorService.executa(transacao)).build();
    }
}
