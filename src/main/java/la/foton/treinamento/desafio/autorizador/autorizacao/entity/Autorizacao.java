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
package la.foton.treinamento.desafio.autorizador.autorizacao.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import la.foton.treinamento.desafio.autorizador.transacao.converter.CanalDeAtendimentoConverter;
import la.foton.treinamento.desafio.autorizador.transacao.converter.TipoDaTransacaoConverter;
import la.foton.treinamento.desafio.autorizador.transacao.entity.CanalDeAtendimento;
import la.foton.treinamento.desafio.autorizador.transacao.entity.TipoDaTransacao;

@Entity
@Table(name = "AUT")
public class Autorizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTNSUBLK")
	private Long nsu;

	@Column(name = "AUTDATHOR")
	private LocalDateTime dataHora;

	@Column(name = "AUTNSUORI")
	private Long nsuOrigem;

	@Column(name = "AUTDATREF")
	private LocalDate dataReferencia;

	@Convert(converter = CanalDeAtendimentoConverter.class)
	@Column(name = "CNLCOD")
	private CanalDeAtendimento canal;

	@Column(name = "PTACODORI")
	private Integer agenciaOrigem;

	@Convert(converter = TipoDaTransacaoConverter.class)
	@Column(name = "TTRCOD")
	private TipoDaTransacao tipoDaTransacao;

	@Lob
	@Column(name = "AUTTRN")
	private String transacao;

	@Column(name = "AUTMOTNEG")
	private String motivoDaNegacao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "AUTSTA")
	private EstadoDaAutorizacao estado;

	public Autorizacao() {
		this.estado = EstadoDaAutorizacao.NEGADA;
	}

	@PrePersist
	public void prePersist() {
		this.dataHora = LocalDateTime.now();
		this.dataReferencia = LocalDate.now();
	}

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public Long getNsuOrigem() {
		return nsuOrigem;
	}

	public void setNsuOrigem(Long nsuOrigem) {
		this.nsuOrigem = nsuOrigem;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public LocalDate getDataReferencia() {
		return dataReferencia;
	}

	public CanalDeAtendimento getCanal() {
		return canal;
	}

	public void setCanal(CanalDeAtendimento canal) {
		this.canal = canal;
	}

	public Integer getAgenciaOrigem() {
		return agenciaOrigem;
	}

	public void setAgenciaOrigem(Integer agenciaOrigem) {
		this.agenciaOrigem = agenciaOrigem;
	}

	public TipoDaTransacao getTipoDaTransacao() {
		return tipoDaTransacao;
	}

	public void setTipoDaTransacao(TipoDaTransacao tipoDaTransacao) {
		this.tipoDaTransacao = tipoDaTransacao;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	public String getMotivoDaNegacao() {
		return motivoDaNegacao;
	}

	public void setMotivoDaNegacao(String motivoDaNegacao) {
		this.motivoDaNegacao = motivoDaNegacao;
	}

	public EstadoDaAutorizacao getEstado() {
		return estado;
	}

	public void autorizada() {
		this.estado = EstadoDaAutorizacao.AUTORIZADA;
	}

	public void negada() {
		this.estado = EstadoDaAutorizacao.NEGADA;
	}

}
