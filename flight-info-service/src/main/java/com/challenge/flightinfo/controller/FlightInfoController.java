package com.challenge.flightinfo.controller;

import org.springframework.http.ResponseEntity;

import com.challenge.flightinfo.business.model.AirlineInfo;
import com.challenge.flightinfo.business.model.AirportInfo;
import com.challenge.flightinfo.model.JsonResponse;

public interface FlightInfoController {

  ResponseEntity<JsonResponse<AirportInfo>> getAirports();

  ResponseEntity<JsonResponse<AirportInfo>> getAirportInfo(String airportCode);

  ResponseEntity<JsonResponse<AirlineInfo>> getAirlineInfo(String value, String searchType);
}
