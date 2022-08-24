package com.challenge.flightinfo.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.flightinfo.business.api.AirlineApi;
import com.challenge.flightinfo.business.api.AirportApi;
import com.challenge.flightinfo.business.model.AirlineInfo;
import com.challenge.flightinfo.business.model.AirlineSearchType;
import com.challenge.flightinfo.business.model.AirportInfo;

@Service
public class FlightInfoServiceImpl implements FlightInfoService {

  private static final Logger LOGGER = LoggerFactory.getLogger(FlightInfoServiceImpl.class);

  @Autowired
  AirportApi airportApi;

  @Autowired
  AirlineApi airlineApi;

  @Override
  public AirportInfo getAirportInfo(String airportCode) {
    LOGGER.info("> FlightInfoServiceImpl.getAirportInfo() - Requesting Aiport info for code {}", airportCode);
    return airportApi.getAirport(airportCode.toUpperCase());
  }

  @Override
  public List<AirlineInfo> getAirlineInfo(String value, String searchType) {
    AirlineSearchType airlineSearchType = AirlineSearchType.lookup(searchType);

    switch (airlineSearchType) {
      case IATA:
        return airlineApi.getAirlineByIata(value);
      case ICAO:
        return airlineApi.getAirlineByIcao(value);
      case NAME:
        return airlineApi.getAirlineByName(value);

    }

    return null;
  }
}
