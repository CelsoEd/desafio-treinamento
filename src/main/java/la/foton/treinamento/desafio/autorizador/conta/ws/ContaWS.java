package la.foton.treinamento.desafio.autorizador.conta.ws;

import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.conta.dto.ContaDTO;
import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.service.ContaService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("conta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContaWS {

    @EJB
    private ContaService contaService;

    @POST
    @Path("nova")
    public Response novaConta(ContaDTO contaDTO) throws NegocioException {
        Conta conta = contaService.novaConta(contaDTO.getAgencia(),contaDTO.getTipoDoPacoteDeServicos(), contaDTO.getCpfTitular());
        return Response.ok(conta).build();
    }

}
