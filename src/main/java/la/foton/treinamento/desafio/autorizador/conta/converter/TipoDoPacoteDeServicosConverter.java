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
package la.foton.treinamento.desafio.autorizador.conta.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import la.foton.treinamento.desafio.autorizador.conta.entity.TipoDoPacoteDeServicos;

@Converter(autoApply = true)
public class TipoDoPacoteDeServicosConverter implements AttributeConverter<TipoDoPacoteDeServicos, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoDoPacoteDeServicos attribute) {
		if (attribute.getChave() == null) {
			throw new IllegalArgumentException("Unknown" + attribute);
		} else {
			return attribute.getChave();
		}
	}

	@Override
	public TipoDoPacoteDeServicos convertToEntityAttribute(Integer value) {
		switch (value) {
		case 1:
			return TipoDoPacoteDeServicos.BASICO;
		case 2:
			return TipoDoPacoteDeServicos.ESPECIAL;
		default:
			throw new IllegalArgumentException("Unknown" + value);
		}
	}
}