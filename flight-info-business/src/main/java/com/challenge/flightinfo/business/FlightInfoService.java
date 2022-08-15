package com.challenge.flightinfo.business;

import java.util.List;

import com.challenge.flightinfo.business.model.AirlineInfo;
import com.challenge.flightinfo.business.model.AirportInfo;

public interface FlightInfoService {

  AirportInfo getAirportInfo(String airportCode);

  List<AirlineInfo> getAirlineInfo(String value, String searchType);
}
