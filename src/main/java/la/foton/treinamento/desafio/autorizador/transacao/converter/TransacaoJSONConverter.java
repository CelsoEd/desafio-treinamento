package la.foton.treinamento.desafio.autorizador.transacao.converter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import la.foton.treinamento.desafio.autorizador.common.configuration.JSONConverter;
import la.foton.treinamento.desafio.autorizador.transacao.entity.Transacao;

public class TransacaoJSONConverter<T extends Transacao> {

	protected Class<T> classeTransacao;

	public String toJSONFromTransacao(T transacao) throws JsonProcessingException {
		return JSONConverter.MAPPER.writeValueAsString(transacao);
	}

	public Transacao toTransacaoFromJSON(String json) throws IOException {
		return JSONConverter.MAPPER.readValue(json, classeTransacao);
	}

}
