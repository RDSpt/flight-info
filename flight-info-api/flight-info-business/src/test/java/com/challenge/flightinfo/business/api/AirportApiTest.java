package com.challenge.flightinfo.business.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;

import java.math.BigDecimal;

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

import com.challenge.flightinfo.business.model.AirportInfo;

class AirportApiTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private AirportApi instance;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getAirport() {

    ResponseEntity<String> response = new ResponseEntity<>(
      "{\"id\":5640,\"iata\":\"OPO\",\"icao\":\"LPPR\",\"name\":\"Francisco de Sá Carneiro Airport\",\"location\":\"Porto, Portugal\","
        + "\"street_number\":\"\",\"street\":\"\",\"city\":\"Maia\",\"county\":\"\",\"state\":\"Porto District\",\"country_iso\":\"PT\","
        + "\"country\":\"Portugal\",\"postal_code\":\"4470-558\",\"phone\":\"+351 22 943 2400\",\"latitude\":41.24212,\"longitude\":-8"
        + ".678552,\"uct\":60,\"website\":\"http://www.ana.pt/pt-PT/Aeroportos/Porto/Porto/Paginas/HomePorto.aspx\"}", HttpStatus.OK);

    Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class), anyMap()))
      .thenReturn(response);

    AirportInfo exampleAirport = instance.getAirport("exampleAirport");

    assertNotNull(exampleAirport);

    assertNull(exampleAirport.getCode());
    assertEquals("OPO", exampleAirport.getIata());
    assertEquals("LPPR", exampleAirport.getIcao());
    assertEquals("Francisco de Sá Carneiro Airport", exampleAirport.getName());
    assertEquals("Porto, Portugal", exampleAirport.getLocation());
    assertEquals("",exampleAirport.getStreetNumber());
    assertEquals("", exampleAirport.getStreet());
    assertEquals("Maia", exampleAirport.getCity());
    assertEquals("", exampleAirport.getCounty());
    assertEquals("Porto District", exampleAirport.getState());
    assertEquals("PT", exampleAirport.getCountryIso());
    assertEquals("Portugal", exampleAirport.getCountry());
    assertEquals("4470-558", exampleAirport.getPostalCode());
    assertEquals("+351 22 943 2400", exampleAirport.getPhone());
    assertEquals(BigDecimal.valueOf(41.24212), exampleAirport.getLatitude());
    assertEquals(BigDecimal.valueOf(-8.678552), exampleAirport.getLongitude());
    assertEquals(60L, exampleAirport.getUct());
    assertEquals("http://www.ana.pt/pt-PT/Aeroportos/Porto/Porto/Paginas/HomePorto.aspx", exampleAirport.getWebsite());
    assertNull(exampleAirport.getError());

  }
}
