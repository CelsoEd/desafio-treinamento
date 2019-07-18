package la.foton.treinamento.desafio.autorizador.transacao.entity;

import javax.validation.constraints.NotNull;

public class TransacaoDeTransferencia extends Transacao {

    @NotNull
    private Integer agenciaFavorecido;

    @NotNull
    private Integer contaFavorecido;

    public Integer getAgenciaFavorecido() {
        return agenciaFavorecido;
    }

    public void setAgenciaFavorecido(Integer agenciaFavorecido) {
        this.agenciaFavorecido = agenciaFavorecido;
    }

    public Integer getContaFavorecido() {
        return contaFavorecido;
    }

    public void setContaFavorecido(Integer contaFavorecido) {
        this.contaFavorecido = contaFavorecido;
    }

}
