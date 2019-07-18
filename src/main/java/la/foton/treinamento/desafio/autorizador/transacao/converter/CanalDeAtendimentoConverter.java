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

import la.foton.treinamento.desafio.autorizador.transacao.entity.CanalDeAtendimento;

@Converter(autoApply = true)
public class CanalDeAtendimentoConverter implements AttributeConverter<CanalDeAtendimento, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CanalDeAtendimento attribute) {
		if (attribute.getChave() == null) {
			throw new IllegalArgumentException("Unknown" + attribute);
		} else {
			return attribute.getChave();
		}
	}

	@Override
	public CanalDeAtendimento convertToEntityAttribute(Integer value) {
		switch (value) {
		case 1:
			return CanalDeAtendimento.NEXTBANK;
		case 2:
			return CanalDeAtendimento.NETBANKING;
		case 3:
			return CanalDeAtendimento.MYPHONE;
		case 4:
			return CanalDeAtendimento.EXTRACASH;
		default:
			throw new IllegalArgumentException("Unknown" + value);
		}
	}
}