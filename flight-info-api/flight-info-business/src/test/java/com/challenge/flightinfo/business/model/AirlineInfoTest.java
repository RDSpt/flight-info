package com.challenge.flightinfo.business.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirlineInfoTest {

  private AirlineInfo instance;

  @BeforeEach
  void setup() {
    instance = new AirlineInfo();
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
  void getLogo_url() {
    String expected = "url";
    instance.setLogoUrl(expected);
    assertEquals(expected, instance.getLogoUrl());
  }

  @Test
  void getName() {
    String expected = "iata";
    instance.setName(expected);
    assertEquals(expected, instance.getName());
  }

  @Test
  void getFleet() {
    Map<String, Long> expected = new HashMap<>();
    expected.put("a", 1L);
    instance.setFleet(expected);
    assertEquals(expected, instance.getFleet());
  }

  @Test
  void getFleetInfo() {
    List<AircraftInfo> expected = Collections.singletonList(new AircraftInfo());
    instance.setFleetInfo(expected);
    assertEquals(expected, instance.getFleetInfo());
  }

  @Test
  void addFleetInfo() {
    assertNull(instance.getFleetInfo());
    instance.addFleetInfo(new AircraftInfo());
    assertNotNull(instance.getFleetInfo());
    assertFalse(instance.getFleetInfo().isEmpty());
  }

  @Test
  void testToString() {
    assertNotNull(instance.toString());
  }
}
