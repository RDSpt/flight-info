package com.challenge.flightinfo.business.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirportInfoTest {

  private AirportInfo instance;

  @BeforeEach
  void setup() {
    instance = new AirportInfo();
  }

  @Test
  void getCode() {
    String expected = "code";
    instance.setCode(expected);
    assertEquals(expected, instance.getCode());

  }

  @Test
  void getIata() {
    String expected = "iata";
    instance.setIata(expected);
    assertEquals(expected, instance.getIata());
  }

  @Test
  void getIcao() {
    String expected = "icao";
    instance.setIcao(expected);
    assertEquals(expected, instance.getIcao());
  }

  @Test
  void getName() {
    String expected = "name";
    instance.setName(expected);
    assertEquals(expected, instance.getName());
  }

  @Test
  void getLocation() {
    String expected = "location";
    instance.setLocation(expected);
    assertEquals(expected, instance.getLocation());
  }

  @Test
  void getStreet_number() {
    String expected = "streetNumber";
    instance.setStreetNumber(expected);
    assertEquals(expected, instance.getStreetNumber());
  }

  @Test
  void getStreet() {
    String expected = "street";
    instance.setStreet(expected);
    assertEquals(expected, instance.getStreet());
  }

  @Test
  void getCity() {
    String expected = "city";
    instance.setCity(expected);
    assertEquals(expected, instance.getCity());
  }

  @Test
  void getCounty() {
    String expected = "country";
    instance.setCounty(expected);
    assertEquals(expected, instance.getCounty());
  }

  @Test
  void getState() {
    String expected = "state";
    instance.setState(expected);
    assertEquals(expected, instance.getState());
  }

  @Test
  void getCountry_iso() {
    String expected = "countryIso";
    instance.setCountryIso(expected);
    assertEquals(expected, instance.getCountryIso());
  }

  @Test
  void getCountry() {
    String expected = "country";
    instance.setCountry(expected);
    assertEquals(expected, instance.getCountry());
  }

  @Test
  void getPostal_code() {
    String expected = "postalCode";
    instance.setPostalCode(expected);
    assertEquals(expected, instance.getPostalCode());
  }

  @Test
  void getPhone() {
    String expected = "phone";
    instance.setPhone(expected);
    assertEquals(expected, instance.getPhone());
  }

  @Test
  void getLatitude() {
    BigDecimal expected = BigDecimal.ONE;
    instance.setLatitude(expected);
    assertEquals(expected, instance.getLatitude());
  }

  @Test
  void getLongitude() {
    BigDecimal expected = BigDecimal.ONE;
    instance.setLongitude(expected);
    assertEquals(expected, instance.getLongitude());
  }

  @Test
  void getUct() {
    Long expected = 1L;
    instance.setUct(expected);
    assertEquals(expected, instance.getUct());
  }

  @Test
  void getWebsite() {
    String expected = "website";
    instance.setWebsite(expected);
    assertEquals(expected, instance.getWebsite());
  }

  @Test
  void testToString() {
    assertNotNull(instance.toString());
  }
}
