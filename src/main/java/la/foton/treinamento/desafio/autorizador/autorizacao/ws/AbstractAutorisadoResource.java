package la.foton.treinamento.desafio.autorizador.autorizacao.ws;

import la.foton.treinamento.desafio.autorizador.autorizacao.entity.Autorizacao;
import la.foton.treinamento.desafio.autorizador.autorizacao.service.AutorizadorService;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;

import javax.ejb.EJB;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public abstract class AbstractAutorisadoResource {

    @EJB
    protected AutorizadorService service;

    protected Response executa(Transacao transacao) {
        Autorizacao autorizacao = service.executa(transacao);

        if (autorizacao != null && autorizacao.getNsu() != null) {
            URI uri = UriBuilder.fromPath("autorizacao/{id}").build(autorizacao.getNsu());

            return Response.created(uri).entity(autorizacao).type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        return Response.serverError().build();
    }
}
