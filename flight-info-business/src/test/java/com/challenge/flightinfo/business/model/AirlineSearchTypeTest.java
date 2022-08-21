package com.challenge.flightinfo.business.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AirlineSearchTypeTest {

  @ParameterizedTest
  @CsvSource(value = {"NAME", "ICAO", "IATA"})
  void lookup(String searchType) {
    assertNotNull(AirlineSearchType.lookup(searchType));
  }
}
