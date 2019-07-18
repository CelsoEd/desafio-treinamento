package la.foton.treinamento.desafio.autorizador.conta.dto;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;
import la.foton.treinamento.desafio.autorizador.conta.entity.Conta;
import la.foton.treinamento.desafio.autorizador.conta.entity.EstadoDaConta;
import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoPacoteDeServicos;

import java.math.BigDecimal;

public class ContaResponseDTO {

    private Integer agencia;
    private Integer numero;
    private BigDecimal saldo;
    private Cliente titular;
    private EstadoDaConta estado;
    private TipoDoPacoteDeServicos tipoDoPacoteDeServicos;

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public EstadoDaConta getEstado() {
        return estado;
    }

    public void setEstado(EstadoDaConta estado) {
        this.estado = estado;
    }

    public TipoDoPacoteDeServicos getTipoDoPacoteDeServicos() {
        return tipoDoPacoteDeServicos;
    }

    public void setTipoDoPacoteDeServicos(TipoDoPacoteDeServicos tipoDoPacoteDeServicos) {
        this.tipoDoPacoteDeServicos = tipoDoPacoteDeServicos;
    }

    public static ContaResponseDTO paraDTO(Conta conta) {
        ContaResponseDTO contaResponseDTO = new ContaResponseDTO();
        contaResponseDTO.setAgencia(conta.getAgencia());
        contaResponseDTO.setEstado(conta.getEstado());
        contaResponseDTO.setNumero(conta.getNumero());
        contaResponseDTO.setSaldo(conta.getSaldo());
        contaResponseDTO.setTipoDoPacoteDeServicos(conta.getTipoDoPacoteDeServicos());
        contaResponseDTO.setTitular(conta.getTitular());
        return contaResponseDTO;
    }
}
