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
package la.foton.treinamento.desafio.autorizador.log.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
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
@Table(name = "LOG")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOGNSU")
	private Long nsu;

	@Column(name = "LOGDATHOR")
	private LocalDateTime dataHora;

	@Column(name = "LOGDATREF")
	private LocalDate dataRefencia;

	@Column(name = "PTACOD")
	private Integer agencia;

	@Column(name = "TTRCOD")
	@Convert(converter = TipoDaTransacaoConverter.class)
	private TipoDaTransacao tipoDaTransacao;

	@Column(name = "CNLCOD")
	@Convert(converter = CanalDeAtendimentoConverter.class)
	private CanalDeAtendimento canal;

	@Lob
	@Column(name = "LOGPRT")
	private String particao;

	@PrePersist
	public void prePersist() {
		this.dataHora = LocalDateTime.now();
	}

	public Long getNsu() {
		return nsu;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public LocalDate getDataRefencia() {
		return dataRefencia;
	}

	public void setDataRefencia(LocalDate dataRefencia) {
		this.dataRefencia = dataRefencia;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public TipoDaTransacao getTipoDaTransacao() {
		return tipoDaTransacao;
	}

	public void setTipoDaTransacao(TipoDaTransacao tipoDaTransacao) {
		this.tipoDaTransacao = tipoDaTransacao;
	}

	public CanalDeAtendimento getCanal() {
		return canal;
	}

	public void setCanal(CanalDeAtendimento canal) {
		this.canal = canal;
	}

	public String getParticao() {
		return particao;
	}

	public void setParticao(String particao) {
		this.particao = particao;
	}

}
