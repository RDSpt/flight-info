package com.challenge.flightinfo.business.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AircraftInfoTest {
  private AircraftInfo instance;

  @BeforeEach
  void setup() {
    instance = new AircraftInfo();
  }

  @Test
  void getCode() {
    String expected = "code";
    instance.setCode(expected);
    assertEquals(expected, instance.getCode());
  }

  @Test
  void getManufacturer() {
    String expected = "manufacturer";
    instance.setManufacturer(expected);
    assertEquals(expected, instance.getManufacturer());
  }

  @Test
  void getModelName() {
    String expected = "modelName";
    instance.setModelName(expected);
    assertEquals(expected, instance.getModelName());
  }

  @Test
  void getUld320Capable() {
    instance.setUld320Capable(false);
    assertFalse(instance.getUld320Capable());
  }

  @Test
  void getWideBody() {
    instance.setWideBody(true);
    assertTrue(instance.getWideBody());
  }

  @Test
  void getQuantity() {
    Long expected = 1L;
    instance.setQuantity(expected);
    assertEquals(expected, instance.getQuantity());
  }

  @Test
  void testToString() {
    assertNotNull(instance.toString());
  }
}
