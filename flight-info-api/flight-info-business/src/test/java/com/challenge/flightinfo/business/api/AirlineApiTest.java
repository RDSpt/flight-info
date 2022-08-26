package com.challenge.flightinfo.business.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.List;

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

import com.challenge.flightinfo.business.model.AirlineInfo;

class AirlineApiTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private AirlineApi instance;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getAirlineByIcao() {

    ResponseEntity<String> response = new ResponseEntity<>("[{\"iata\":\"testIata\", \"icao\":\"testIcao\", \"logo_url\":\"www.example.com\", \"name\":\"exampleAirline\"}]", HttpStatus.OK);

    Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class), anyMap()))
      .thenReturn(response);

    List<AirlineInfo> exampleIcao = instance.getAirlineByIcao("exampleIcao");

    assertFalse(exampleIcao.isEmpty());
    assertNotNull(exampleIcao.get(0));
    assertEquals("testIata",exampleIcao.get(0).getIata());
    assertEquals("testIcao",exampleIcao.get(0).getIcao());
    assertEquals("www.example.com",exampleIcao.get(0).getLogoUrl());
    assertEquals("exampleAirline",exampleIcao.get(0).getName());
  }

  @Test
  void getAirlineByName() {

    ResponseEntity<String> response = new ResponseEntity<>("[{\"iata\":\"testIata\", \"icao\":\"testIcao\", \"logo_url\":\"www.example.com\", \"name\":\"exampleAirline\"}]", HttpStatus.OK);

    Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class), anyMap()))
      .thenReturn(response);

    List<AirlineInfo> exampleIcao = instance.getAirlineByName("exampleName");

    assertFalse(exampleIcao.isEmpty());
    assertNotNull(exampleIcao.get(0));
    assertEquals("testIata",exampleIcao.get(0).getIata());
    assertEquals("testIcao",exampleIcao.get(0).getIcao());
    assertEquals("www.example.com",exampleIcao.get(0).getLogoUrl());
    assertEquals("exampleAirline",exampleIcao.get(0).getName());

  }

  @Test
  void getAirlineByIata() {

    ResponseEntity<String> response = new ResponseEntity<>("[{\"iata\":\"testIata\", \"icao\":\"testIcao\", \"logo_url\":\"www.example.com\", \"name\":\"exampleAirline\"}]", HttpStatus.OK);

    Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class), anyMap()))
      .thenReturn(response);

    List<AirlineInfo> exampleIcao = instance.getAirlineByIata("exampleIata");

    assertFalse(exampleIcao.isEmpty());
    assertNotNull(exampleIcao.get(0));
    assertEquals("testIata",exampleIcao.get(0).getIata());
    assertEquals("testIcao",exampleIcao.get(0).getIcao());
    assertEquals("www.example.com",exampleIcao.get(0).getLogoUrl());
    assertEquals("exampleAirline",exampleIcao.get(0).getName());

  }

}
