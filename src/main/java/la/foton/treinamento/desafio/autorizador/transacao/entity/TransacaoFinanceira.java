package la.foton.treinamento.desafio.autorizador.transacao.entity;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransacaoFinanceira extends Transacao {

    private  static final long serialVersionUID = 1L;

    @NotNull
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
