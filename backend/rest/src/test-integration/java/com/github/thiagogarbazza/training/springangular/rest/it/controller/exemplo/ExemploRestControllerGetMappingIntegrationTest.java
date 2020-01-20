package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.ValuesD4T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class ExemploRestControllerGetMappingIntegrationTest {

  @Captor
  private ArgumentCaptor<ExemploDataVO> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private ExemploRestService exemploRestService;
  private MockMvc mockMvc;
  private ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @BeforeEach
  final void beforeEach() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifyGetQueryParametersTypeBoolean() throws Exception {
    final ExemploDataVO exemploDataVO = ExemploDataVO.builder()
      .condition(ValuesD4T.BOOLEAN)
      .conditions(Arrays.asList(ValuesD4T.BOOLEAN_ARRAY))
      .build();
    final String content = this.objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(get("/end-point-exemplo/get")
      .param("condition", "true")
      .param("conditions", "true", "false"))
      .andDo(result -> {
        final ExemploDataVO actual = captor.getValue();
        assertEquals(exemploDataVO.getCondition(), actual.getCondition());
        assertIterableEquals(exemploDataVO.getConditions(), actual.getConditions());
      })
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }

  @Test
  void verifyGetQueryParametersTypeLocalDate() throws Exception {
    final ExemploDataVO exemploDataVO = ExemploDataVO.builder()
      .localDate(ValuesD4T.LOCAL_DATE)
      .localDates(Arrays.asList(ValuesD4T.LOCAL_DATE_ARRAY))
      .build();
    final String content = this.objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(get("/end-point-exemplo/get")
      .param("localDate", "2019-12-31")
      .param("localDates", "2019-01-01", "2019-01-31", "2019-12-01", "2019-12-31"))
      .andDo(result -> {
        final ExemploDataVO actual = captor.getValue();
        assertEquals(exemploDataVO.getLocalDate(), actual.getLocalDate());
        assertIterableEquals(exemploDataVO.getLocalDates(), actual.getLocalDates());
      })
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }

  @Test
  void verifyGetQueryParametersTypeLocalDateTime() throws Exception {
    final ExemploDataVO exemploDataVO = ExemploDataVO.builder()
      .localDateTime(ValuesD4T.LOCAL_DATE_TIME)
      .localDateTimes(Arrays.asList(ValuesD4T.LOCAL_DATE_TIME_ARRAY))
      .build();
    final String content = this.objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(get("/end-point-exemplo/get")
      .param("localDateTime", "2019-12-31T23:59:59")
      .param("localDateTimes", "2019-01-01T23:59:59", "2019-01-31T00:00:01", "2019-12-01T00:01:02", "2019-12-31T01:02:03"))
      .andDo(result -> {
        final ExemploDataVO actual = captor.getValue();
        assertEquals(exemploDataVO.getLocalDateTime(), actual.getLocalDateTime());
        assertIterableEquals(exemploDataVO.getLocalDateTimes(), actual.getLocalDateTimes());
      })
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }

  @Test
  void verifyGetQueryParametersTypeNumberBigDecimal() throws Exception {
    final ExemploDataVO exemploDataVO = ExemploDataVO.builder()
      .numberBigDecimal(ValuesD4T.NUMBER_BIG_DECIMAL)
      .numberBigDecimals(Arrays.asList(ValuesD4T.NUMBER_BIG_DECIMAL_ARRAY))
      .build();
    final String content = this.objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(get("/end-point-exemplo/get")
      .param("numberBigDecimal", "3.14")
      .param("numberBigDecimals", "3", "99.1", "987.001"))
      .andDo(result -> {
        final ExemploDataVO actual = captor.getValue();
        assertEquals(exemploDataVO.getNumberBigDecimal(), actual.getNumberBigDecimal());
        assertIterableEquals(exemploDataVO.getNumberBigDecimals(), actual.getNumberBigDecimals());
      })
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }

  @Test
  void verifyGetQueryParametersTypeNumberInteger() throws Exception {
    final ExemploDataVO exemploDataVO = ExemploDataVO.builder()
      .numberInteger(ValuesD4T.NUMBER_INTEGER)
      .numberIntegers(Arrays.asList(ValuesD4T.NUMBER_INTEGER_ARRAY))
      .build();
    final String content = this.objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(get("/end-point-exemplo/get")
      .param("numberInteger", "7727")
      .param("numberIntegers", "7741", "7753", "7757"))
      .andDo(result -> {
        final ExemploDataVO actual = captor.getValue();
        assertEquals(exemploDataVO.getNumberInteger(), actual.getNumberInteger());
        assertIterableEquals(exemploDataVO.getNumberIntegers(), actual.getNumberIntegers());
      })
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }

  @Test
  void verifyGetQueryParametersTypeText() throws Exception {
    final ExemploDataVO exemploDataVO = ExemploDataVO.builder()
      .text(ValuesD4T.TEXT)
      .text2(ValuesD4T.TEXT_2)
      .texts(Arrays.asList(ValuesD4T.TEXT_ARRAY))
      .build();
    final String content = this.objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(get("/end-point-exemplo/get")
      .param("text", ValuesD4T.TEXT)
      .param("text2", ValuesD4T.TEXT_2)
      .param("texts", ValuesD4T.TEXT_ARRAY))
      .andDo(result -> {
        final ExemploDataVO actual = captor.getValue();
        assertEquals(exemploDataVO.getText(), actual.getText());
        assertEquals(exemploDataVO.getText2(), actual.getText2());
        assertIterableEquals(exemploDataVO.getTexts(), actual.getTexts());
      })
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }
}
