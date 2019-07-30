package la.foton.treinamento.desafio.autorizador.conta.dto;

import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoPacoteDeServicos;

public class ContaDTO {

    private Integer agencia;
    private String cpfTitular;
    private TipoDoPacoteDeServicos tipoDoPacoteDeServicos;

    public Integer getAgencia() {
        return agencia;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public TipoDoPacoteDeServicos getTipoDoPacoteDeServicos() {
        return tipoDoPacoteDeServicos;
    }


}
