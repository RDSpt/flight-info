package com.challenge.flightinfo.business.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.challenge.flightinfo.business.model.AircraftInfo;

class AircraftApiTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private AircraftApi instance;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getByIcao() {

    ResponseEntity<String> response = new ResponseEntity<>(
      "{\"code\":\"B38M\",\"manufacturer\":\"BOEING\",\"modelName\":\"737\",\"wideBody\":false,\"uld320Capable\":true}", HttpStatus.OK);

    Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class), anyMap()))
      .thenReturn(response);

    AircraftInfo exampleIcao = instance.getByIcao("exampleIcao");

    assertNotNull(exampleIcao);
    assertEquals("B38M", exampleIcao.getCode());
    assertEquals("BOEING", exampleIcao.getManufacturer());
    assertEquals("737", exampleIcao.getModelName());
    Assertions.assertFalse(exampleIcao.getWideBody());
    Assertions.assertTrue(exampleIcao.getUld320Capable());
  }
}
