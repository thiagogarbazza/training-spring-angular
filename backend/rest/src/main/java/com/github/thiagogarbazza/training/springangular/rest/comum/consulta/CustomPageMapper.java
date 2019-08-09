package com.github.thiagogarbazza.training.springangular.rest.comum.consulta;

import com.github.thiagogarbazza.training.springangular.rest.configuration.mapper.AssemblerMapper;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
class CustomPageMapper extends CustomMapper<CustomPage, CustomPageResource> implements AssemblerMapper {

  @Override
  public void configure(final MapperFactory mapperFactory) {
    mapperFactory.classMap(CustomPage.class, CustomPageResource.class)
      .customize(this)
      .byDefault()
      .register();
  }

  @Override
  public void mapAtoB(final CustomPage page, final CustomPageResource pageResource, final MappingContext ctx) {
    pageResource.setHasContent(page.hasContent());
    pageResource.setHasNext(page.hasNext());
    pageResource.setHasPrevious(page.hasPrevious());
    pageResource.setFirst(page.isFirst());
    pageResource.setLast(page.isLast());
    pageResource.setPageNumber(page.getNumber());
    pageResource.setContentSize(page.getNumberOfElements());
    pageResource.setPageSize(page.getSize());
    pageResource.setTotalElements(page.getTotalElements());
    pageResource.setTotalPages(page.getTotalPages());

    pageResource.setMessages(page.getMessages());

    if (page.hasPrevious()) {
      Pageable previous = page.previousPageable();
      pageResource.setPagePrevious(previous.getPageNumber());
    }

    if (page.hasNext()) {
      Pageable next = page.nextPageable();
      pageResource.setPageNext(next.getPageNumber());
    }
  }
}
