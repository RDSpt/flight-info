package com.challenge.flightinfo.business.model;

import java.util.HashMap;
import java.util.Map;

public enum AirlineSearchType {
  NAME,
  ICAO,
  IATA;

  private static final Map<String,AirlineSearchType> LOOKUP = new HashMap<>();


  static{
    for (AirlineSearchType search : AirlineSearchType.values()){
      LOOKUP.put(search.name(), search);
    }
  }

  public static AirlineSearchType lookup(String value){
    return value == null ? null : LOOKUP.get(value);
  }
}
