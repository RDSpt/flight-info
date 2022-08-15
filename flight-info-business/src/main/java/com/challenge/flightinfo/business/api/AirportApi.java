package com.challenge.flightinfo.business.api;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.challenge.flightinfo.business.model.AirportInfo;
import com.google.gson.Gson;

@Component
public class AirportApi extends ApiIntegration {

  private static final String URL = "https://airport-info.p.rapidapi.com";

  public AirportApi() {
    super(URL);
    addHeader("X-RapidAPI-Key", "31134d3e19msh48e6b2f4e6d24e9p105587jsn337210ed41a0");
    addHeader("'X-RapidAPI-Host", "airport-info.p.rapidapi.com");
  }

  public AirportInfo getAirport(String airportCode) {
    HashMap<String, String> parameters = new HashMap<>();
    parameters.put(ENDPOINT.AIRPORT.getParameters()[0], airportCode);

    String jsonResponse = get(ENDPOINT.AIRPORT.getEndpointUrl(), parameters);
    return new Gson().fromJson(jsonResponse, AirportInfo.class);

  }

  public enum ENDPOINT {
    AIRPORT("/airport?iata={iata}", "iata");

    final String endpointUrl;
    final String[] parameters;

    ENDPOINT(String endpointUrl, String... parameters) {
      this.endpointUrl = endpointUrl;
      this.parameters = parameters;
    }

    public String getEndpointUrl() {
      return endpointUrl;
    }

    public String[] getParameters() {
      return parameters;
    }
  }

}
