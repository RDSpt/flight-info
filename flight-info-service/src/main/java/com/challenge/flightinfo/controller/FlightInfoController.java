package com.challenge.flightinfo.controller;

import org.springframework.http.ResponseEntity;

import com.challenge.flightinfo.business.model.AirportInfo;
import com.challenge.flightinfo.model.JsonResponse;

public interface FlightInfoController {


  ResponseEntity<JsonResponse<AirportInfo>> getAirportInfo(String airportCode);
}
