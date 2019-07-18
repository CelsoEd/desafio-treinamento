package la.foton.treinamento.desafio.autorizador.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NegocioExceptionMapper implements ExceptionMapper<NegocioException> {
    @Override
    public Response toResponse(NegocioException e) {
        Erro erro = new Erro(e.getMessage());
        return Response
                .status(e.getStatus() == null ? Response.Status.BAD_REQUEST : e.getStatus())
                .entity(erro)
                .build();
    }
}
