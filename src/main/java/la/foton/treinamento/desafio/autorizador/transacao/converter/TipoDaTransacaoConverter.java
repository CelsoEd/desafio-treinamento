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
package la.foton.treinamento.desafio.autorizador.transacao.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import la.foton.treinamento.desafio.autorizador.transacao.entity.TipoDaTransacao;

@Converter(autoApply = true)
public class TipoDaTransacaoConverter implements AttributeConverter<TipoDaTransacao, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoDaTransacao attribute) {
		if (attribute.getChave() == null) {
			throw new IllegalArgumentException("Unknown" + attribute);
		} else {
			return attribute.getChave();
		}
	}

	@Override
	public TipoDaTransacao convertToEntityAttribute(Integer value) {
		switch (value) {
		case 10:
			return TipoDaTransacao.SAQUE_EM_CONTA;
		case 20:
			return TipoDaTransacao.DEPOSITO_EM_CONTA;
		case 30:
			return TipoDaTransacao.TRANSFERENCIA_ENTRE_CONTAS;
		case 40:
			return TipoDaTransacao.INVESTIMENTO_EM_FUNDO;
		case 50:
			return TipoDaTransacao.DOC_TED;
		case 60:
			return TipoDaTransacao.EXTRATO;
		default:
			throw new IllegalArgumentException("Unknown" + value);
		}
	}
}