package la.foton.treinamento.desafio.autorizador.conta.entity;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;
import la.foton.treinamento.desafio.autorizador.common.exception.Mensagem;
import la.foton.treinamento.desafio.autorizador.common.exception.NegocioException;
import la.foton.treinamento.desafio.autorizador.conta.converter.TipoDoPacoteDeServicosConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "CTA")
@Entity
@IdClass(ContaPK.class)
public class Conta {

    @Column(name = "CTASLD")
    protected BigDecimal saldo;
    @Id
    @Column(name = "PTACOD")
    private Integer agencia;
    @Id
    @Column(name = "CTANUM")
    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "CLTCPF")
    private Cliente titular;

    @Column(name = "CTASTA")
    @Enumerated(EnumType.ORDINAL)
    private EstadoDaConta estado;

    @Column(name = "CTAPSV")
    @Convert(converter = TipoDoPacoteDeServicosConverter.class)
    private TipoDoPacoteDeServicos tipoDoPacoteDeServicos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conta")
    private List<LancamentoDaConta> lancamentos;

    @PrePersist
    public void prePersist() {
        saldo = BigDecimal.ZERO;
        estado = EstadoDaConta.ATIVA;
    }

    public void credita(BigDecimal valor) throws NegocioException {
        validaSeValorEhMaiorQueZero(valor);
        saldo = saldo.add(valor);
    }

    public void debita(BigDecimal valor) throws NegocioException {
        validaSeValorEhMaiorQueZero(valor);
        if (saldo.compareTo(valor) < 0) {
            throw new NegocioException(Mensagem.SALDO_INSUFICIENTE);
        }
        saldo = saldo.subtract(valor);
    }

    public void transfere(BigDecimal valor, Conta contaFavorecido) throws NegocioException {
        debita(valor);
        contaFavorecido.credita(valor);
    }

    private void validaSeValorEhMaiorQueZero(BigDecimal valor) throws NegocioException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegocioException(Mensagem.VALOR_PRECISA_SER_MAIOR_QUE_ZERO);
        }
    }

    public void encerra() {
        estado = EstadoDaConta.ENCERRADA;
    }

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

    public List<LancamentoDaConta> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<LancamentoDaConta> lancamentos) {
        this.lancamentos = lancamentos;
    }

}
