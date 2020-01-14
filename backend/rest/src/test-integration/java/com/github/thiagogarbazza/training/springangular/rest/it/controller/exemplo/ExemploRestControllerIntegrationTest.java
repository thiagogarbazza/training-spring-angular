package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO.getExemploDataVO;
import static com.github.thiagogarbazza.training.springangular.util.calendario.LocalDateUtil.localDateToString;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class ExemploRestControllerIntegrationTest {

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
  void verifyTypeBooleanRequestBody() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.post(captor.capture())).thenReturn(exemploDataVO);

    final String content = String.format("{\"condition\":%s,\"conditions\":%s}",
      objectMapper.writeValueAsString(exemploDataVO.getCondition()),
      objectMapper.writeValueAsString(exemploDataVO.getConditions()));
    this.mockMvc
      .perform(post("/end-point-exemplo/post").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getCondition(), value.getCondition());
        assertIterableEquals(exemploDataVO.getConditions(), value.getConditions());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.condition", equalTo(exemploDataVO.getCondition())))
      .andExpect(jsonPath("$.conditions", equalTo(exemploDataVO.getConditions())));
  }

  @Test
  void verifyTypeBooleanRequestParam() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc
      .perform(get("/end-point-exemplo/get?a=a"
          + "&condition=" + exemploDataVO.getCondition()
          + "&conditions=" + join(exemploDataVO.getConditions(), "&conditions=")
                  ))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getCondition(), value.getCondition());
        assertIterableEquals(exemploDataVO.getConditions(), value.getConditions());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.condition", equalTo(exemploDataVO.getCondition())))
      .andExpect(jsonPath("$.conditions", equalTo(exemploDataVO.getConditions())));
  }

  @Test
  @Disabled
  void verifyTypeLocalDateRequestBody() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.post(captor.capture())).thenReturn(exemploDataVO);

    final String content = String.format("{\"localDate\":%s,\"localDates\":%s}",
      localDateToString(exemploDataVO.getLocalDate(), "\"yyyy-MM-dd\""),
      exemploDataVO.getLocalDates().stream().map(d -> localDateToString(d, "\"yyyy-MM-dd\"")).collect(toList()));
    this.mockMvc
      .perform(post("/end-point-exemplo/post").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getLocalDate(), value.getLocalDate());
        assertIterableEquals(exemploDataVO.getLocalDates(), value.getLocalDates());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.localDate", equalTo(localDateToString(exemploDataVO.getLocalDate(), "yyyy-MM-dd"))))
      .andExpect(
        jsonPath("$.localDates", equalTo(exemploDataVO.getLocalDates().stream().map(d -> localDateToString(d, "\"yyyy-MM-dd\"")).collect(toList()))));
  }

  @Test
  @Disabled
  void verifyTypeLocalDateRequestParam() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc
      .perform(get("/end-point-exemplo/get?a=a"
          + "&localDate=" + localDateToString(exemploDataVO.getLocalDate(), "yyyy-MM-dd")
          + "&localDates=" + join(exemploDataVO.getLocalDates().stream().map(d -> localDateToString(d, "yyyy-MM-dd")).collect(toList()),
        "&localDates=")
                  ))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getLocalDate(), value.getLocalDate());
        assertIterableEquals(exemploDataVO.getLocalDates(), value.getLocalDates());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.localDate", equalTo(exemploDataVO.getLocalDate())))
      .andExpect(jsonPath("$.localDates", equalTo(exemploDataVO.getLocalDates())));
  }

  @Test
  @Disabled
  void verifyTypeNumberBigDecimalRequestBody() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.post(captor.capture())).thenReturn(exemploDataVO);

    final String content = String.format("{\"numberBigDecimal\":%s,\"numberBigDecimals\":%s}",
      objectMapper.writeValueAsString(exemploDataVO.getNumberBigDecimal()),
      objectMapper.writeValueAsString(exemploDataVO.getNumberBigDecimals()));
    this.mockMvc
      .perform(post("/end-point-exemplo/post").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getNumberBigDecimal(), value.getNumberBigDecimal());
        assertIterableEquals(exemploDataVO.getNumberBigDecimals(), value.getNumberBigDecimals());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.numberBigDecimal", equalTo(exemploDataVO.getNumberBigDecimal())))
      .andExpect(jsonPath("$.numberBigDecimals", equalTo(exemploDataVO.getNumberBigDecimals())));
  }

  @Test
  @Disabled
  void verifyTypeNumberBigDecimalRequestParam() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc
      .perform(get("/end-point-exemplo/get?a=a"
          + "&numberBigDecimal=" + exemploDataVO.getNumberBigDecimal()
          + "&numberBigDecimals=" + join(exemploDataVO.getNumberBigDecimals(), "&numberBigDecimals=")
                  ))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getNumberBigDecimal(), value.getNumberBigDecimal());
        assertIterableEquals(exemploDataVO.getNumberBigDecimals(), value.getNumberBigDecimals());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.numberBigDecimal", equalTo(exemploDataVO.getNumberBigDecimal())))
      .andExpect(jsonPath("$.numberBigDecimals", equalTo(exemploDataVO.getNumberBigDecimals())));
  }

  @Test
  void verifyTypeNumberIntegerRequestBody() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.post(captor.capture())).thenReturn(exemploDataVO);

    final String content = String.format("{\"numberInteger\":%s,\"numberIntegers\":%s}",
      objectMapper.writeValueAsString(exemploDataVO.getNumberInteger()),
      objectMapper.writeValueAsString(exemploDataVO.getNumberIntegers()));
    this.mockMvc
      .perform(post("/end-point-exemplo/post").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getNumberInteger(), value.getNumberInteger());
        assertIterableEquals(exemploDataVO.getNumberIntegers(), value.getNumberIntegers());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.numberInteger", equalTo(exemploDataVO.getNumberInteger())))
      .andExpect(jsonPath("$.numberIntegers", equalTo(exemploDataVO.getNumberIntegers())));
  }

  @Test
  void verifyTypeNumberIntegerRequestParam() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc
      .perform(get("/end-point-exemplo/get?a=a"
          + "&numberInteger=" + exemploDataVO.getNumberInteger()
          + "&numberIntegers=" + join(exemploDataVO.getNumberIntegers(), "&numberIntegers=")
                  ))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getNumberInteger(), value.getNumberInteger());
        assertIterableEquals(exemploDataVO.getNumberIntegers(), value.getNumberIntegers());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.numberInteger", equalTo(exemploDataVO.getNumberInteger())))
      .andExpect(jsonPath("$.numberIntegers", equalTo(exemploDataVO.getNumberIntegers())));
  }

  @Test
  void verifyTypeTextRequestBody() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.post(captor.capture())).thenReturn(exemploDataVO);

    final String content = String.format("{\"text\":%s,\"texts\":%s}",
      objectMapper.writeValueAsString(exemploDataVO.getText()),
      objectMapper.writeValueAsString(exemploDataVO.getTexts()));
    this.mockMvc
      .perform(post("/end-point-exemplo/post").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getText(), value.getText());
        assertIterableEquals(exemploDataVO.getTexts(), value.getTexts());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.text", equalTo(exemploDataVO.getText())))
      .andExpect(jsonPath("$.texts", equalTo(exemploDataVO.getTexts())));
  }

  @Test
  void verifyTypeTextRequestParam() throws Exception {
    ExemploDataVO exemploDataVO = getExemploDataVO();
    when(exemploRestService.get(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc
      .perform(get("/end-point-exemplo/get?a=a"
          + "&text=" + exemploDataVO.getText()
          + "&texts=" + join(exemploDataVO.getTexts(), "&texts=")
                  ))
      .andDo(result -> {
        ExemploDataVO value = captor.getValue();
        assertEquals(exemploDataVO.getText(), value.getText());
        assertIterableEquals(exemploDataVO.getTexts(), value.getTexts());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.text", equalTo(exemploDataVO.getText())))
      .andExpect(jsonPath("$.texts", equalTo(exemploDataVO.getTexts())));
  }
}
