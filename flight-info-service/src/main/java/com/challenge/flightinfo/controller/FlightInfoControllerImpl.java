package com.challenge.flightinfo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.flightinfo.business.FlightInfoService;
import com.challenge.flightinfo.business.model.AirportInfo;
import com.challenge.flightinfo.model.JsonResponse;
import com.challenge.flightinfo.model.JsonResponseBuilder;

@RestController
@RequestMapping("/flight-info")
public class FlightInfoControllerImpl implements FlightInfoController {

  @Autowired
  FlightInfoService service;

  @Override
  @GetMapping("/airport")
  public ResponseEntity<JsonResponse<AirportInfo>> getAirportInfo(@RequestParam String airportCode) {
    Objects.requireNonNull(airportCode, "Airport Code must not be null");

    AirportInfo info = new AirportInfo();//service.getAirportInfo(airportCode);

    JsonResponse<AirportInfo> response = new JsonResponseBuilder<AirportInfo>().data(info).build();
    return ResponseEntity.ok(response);
  }

}
