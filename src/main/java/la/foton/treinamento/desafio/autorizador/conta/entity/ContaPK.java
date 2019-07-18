package la.foton.treinamento.desafio.autorizador.conta.entity;

import java.io.Serializable;

public class ContaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer agencia;

	private Integer numero;
	
	public ContaPK() {
	}

	public ContaPK(Integer agencia, Integer numero) {
		this.agencia = agencia;
		this.numero = numero;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		ContaPK other = (ContaPK) obj;

		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia)) {
			return false;
		}

		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero)) {
			return false;
		}

		return true;
	}

}
