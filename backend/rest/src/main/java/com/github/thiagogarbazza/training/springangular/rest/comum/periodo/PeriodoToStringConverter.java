package com.github.thiagogarbazza.training.springangular.rest.comum.periodo;

import com.github.thiagogarbazza.training.springangular.util.calendario.Periodo;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import static com.github.thiagogarbazza.training.springangular.util.calendario.PeriodoUtil.periodoToString;

@Component
class PeriodoToStringConverter extends BidirectionalConverter<Periodo, String> {

  @Override
  public String convertTo(final Periodo source, final Type<String> destinationType, final MappingContext mappingContext) {
    return periodoToString(source);
  }

  @Override
  public Periodo convertFrom(final String source, final Type<Periodo> destinationType, final MappingContext mappingContext) {
    throw new NotImplementedException("Não implementado este tipo de conversão.");
  }
}
