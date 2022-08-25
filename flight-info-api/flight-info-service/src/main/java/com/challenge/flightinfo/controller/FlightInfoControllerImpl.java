package com.challenge.flightinfo.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.flightinfo.business.FlightInfoService;
import com.challenge.flightinfo.business.model.AirlineInfo;
import com.challenge.flightinfo.business.model.AirportInfo;
import com.challenge.flightinfo.model.JsonResponse;
import com.challenge.flightinfo.model.JsonResponseBuilder;

@RestController
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.OPTIONS})
@RequestMapping("/flight-info")
public class FlightInfoControllerImpl implements FlightInfoController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FlightInfoControllerImpl.class);

  @Autowired
  FlightInfoService service;

  @Override
  @GetMapping(value = "/airport", params = "airportCode")
  public ResponseEntity<JsonResponse<AirportInfo>> getAirportInfo(@RequestParam String airportCode) {
    Objects.requireNonNull(airportCode, "Airport Code must not be null");
    LOGGER.info("> FlightInfoControllerImpl.getAirportInfo() - Requesting Aiport info for code {}", airportCode);

    AirportInfo info = service.getAirportInfo(airportCode);

    JsonResponse<AirportInfo> response = new JsonResponseBuilder<AirportInfo>().data(info).build();
    LOGGER.info("< FlightInfoControllerImpl.getAirportInfo() - {}", response);
    return ResponseEntity.ok(response);
  }


  @Override
  @GetMapping(value = "/airline", params = {"value", "searchType"})
  public ResponseEntity<JsonResponse<AirlineInfo>> getAirlineInfo(String value, String searchType) {
    //    LOGGER.info("> FlightInfoControllerImpl.getAirportInfo() - Requesting Aiport info for code {}", airportCode);

    List<AirlineInfo> info = service.getAirlineInfo(value, searchType);

    JsonResponse<AirlineInfo> response = new JsonResponseBuilder<AirlineInfo>().data(info).build();
    return ResponseEntity.ok(response);
  }

}
