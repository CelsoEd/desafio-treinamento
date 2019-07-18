package la.foton.treinamento.desafio.autorizador.cliente.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "CLT")
@Entity
public class Cliente {

	@Id
	@Size(max = 11)
	@Column(name = "CLTCPF")
	private String cpf;

	@Column(name = "CLTNOM", nullable = false)
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CLTSTA")
	private SituacaoDoCliente situacao;

	public Cliente() {
		this.situacao = SituacaoDoCliente.PENDENTE;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SituacaoDoCliente getSituacao() {
		return situacao;
	}

	public void ativa() {
		this.situacao = SituacaoDoCliente.ATIVO;
	}
}
