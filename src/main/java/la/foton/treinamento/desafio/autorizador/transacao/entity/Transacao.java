/*
 * Foton Informática.
 * Autor: Flávio Roberto (flavio.silva@foton.la)
 *
 * Autorizador Bancário
 *
 * OBS: Todos os códigos estão sendo oferecidos com a intenção única de
 * estimular o aprendizado. Não podem ser usados com fins comerciais sem
 * autorização prévia do autor. Se redistribuídos para outros sites, o autor e
 * a fonte devem ser sempre citados.
 */
package la.foton.treinamento.desafio.autorizador.transacao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long nsuOrigem;

	@NotNull
	private LocalDateTime dataHora;

	@NotNull
	private CanalDeAtendimento canal;

	@NotNull
	private TipoDaTransacao tipo;

	@NotNull
	private Integer agencia;

	@NotNull
	private Integer conta;

	@NotNull
	private BigDecimal valor;

	public Long getNsuOrigem() {
		return nsuOrigem;
	}

	public void setNsuOrigem(Long nsuOrigem) {
		this.nsuOrigem = nsuOrigem;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public CanalDeAtendimento getCanal() {
		return canal;
	}

	public void setCanal(CanalDeAtendimento canal) {
		this.canal = canal;
	}

	public TipoDaTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaTransacao tipo) {
		this.tipo = tipo;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
