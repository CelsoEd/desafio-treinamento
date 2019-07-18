package la.foton.treinamento.desafio.autorizador.conta.dto;

import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoPacoteDeServicos;

public class ContaDTO {

    private Integer agencia;
    private String cpfTitular;
    private TipoDoPacoteDeServicos tipoDoPacoteDeServicos;

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public TipoDoPacoteDeServicos getTipoDoPacoteDeServicos() {
        return tipoDoPacoteDeServicos;
    }

    public void setTipoDoPacoteDeServicos(TipoDoPacoteDeServicos tipoDoPacoteDeServicos) {
        this.tipoDoPacoteDeServicos = tipoDoPacoteDeServicos;
    }

    public Conta paraConta() {
        Conta conta = new Conta();
        conta.setAgencia(agencia);
        conta.setTipoDoPacoteDeServicos(tipoDoPacoteDeServicos);
        return conta;
    }
}
