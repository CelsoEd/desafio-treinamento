package la.foton.treinamento.desafio.autorizador.conta.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "LAN")
@Entity
public class LancamentoDaConta {

    @Id
    @Column(name = "LANSEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequencial;

    @Column(name = "LANDATHOR")
    private LocalDateTime dataHora;

    @Column(name = "LANTIP")
    @NotNull
    private TipoDoLancamento tipo;

    @Column(name = "LANDES")
    @Size(max = 50)
    private String descricao;

    @Column(name = "LANVAL")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "LANPTACOD", referencedColumnName = "PTACOD"),
            @JoinColumn(name = "LANCTANUM", referencedColumnName = "CTANUM")
    })
    private Conta conta;

    public LancamentoDaConta() {
    }

    public LancamentoDaConta(TipoDoLancamento tipo, String descricao, BigDecimal valor, Conta conta) {
        super();
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.conta = conta;
    }

    @PrePersist
    public void prePersist() {
        this.dataHora = LocalDateTime.now();
    }

    public Long getSequencial() {
        return sequencial;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoDoLancamento getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
