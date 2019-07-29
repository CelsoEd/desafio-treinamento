package la.foton.treinamento.desafio.autorizador.cliente.ws;

import la.foton.treinamento.desafio.autorizador.cliente.dto.ClienteDTO;
import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;
import la.foton.treinamento.desafio.autorizador.cliente.service.ClienteService;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteWS {

    @EJB
    private ClienteService clienteService;

    @POST
    @Path("novo")
    public Response novoCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.novoCliente(clienteDTO.getNome(), clienteDTO.getCpf());
        return Response.created(UriBuilder.fromPath("cliente/consulta/{cpf}").build(cliente.getCpf())).build();
    }

    @PUT
    @Path("ativa/{cpf}")
    public Response ativaCliente(@PathParam("cpf") String cpf) throws NegocioException {
        clienteService.ativaCliente(cpf);
        return Response.ok().build();
    }

    @GET
    @Path("consulta/{cpf}")
    public Response consultaCliente(@PathParam("cpf") String cpf) throws NegocioException {
        return Response.ok(clienteService.consultaCliente(cpf)).build();
    }

    @GET
    @Path("/todos")
    public Response buscarTodos() throws NegocioException {
        return Response.ok(clienteService.listaTodas()).build();
    }

    @GET
    public Response teste(){
        return Response.ok().build();
    }

}
