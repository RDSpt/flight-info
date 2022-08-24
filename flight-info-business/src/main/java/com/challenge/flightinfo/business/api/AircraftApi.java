package com.challenge.flightinfo.business.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.flightinfo.business.model.AircraftInfo;
import com.challenge.flightinfo.business.model.AirlineInfo;
import com.google.gson.Gson;

@Component
public class AircraftApi extends ApiIntegration {

  private static final String URL = "https://aviation-reference-data.p.rapidapi.com/icaoType/";

  public AircraftApi() {
    super(URL);
    addHeader("X-RapidAPI-Key", "31134d3e19msh48e6b2f4e6d24e9p105587jsn337210ed41a0");
    addHeader("'X-RapidAPI-Host", "aviation-reference-data.p.rapidapi.com");
  }


  public AircraftInfo getByIcao(String icao) {
    HashMap<String, String> parameters = new HashMap<>();
    parameters.put(ENDPOINT.ICAO.getParameters()[0], icao);

    String jsonResponse = get(ENDPOINT.ICAO.getEndpointUrl(), parameters);
    AircraftInfo aircraftInfo= new Gson().fromJson(jsonResponse, AircraftInfo.class);

    return aircraftInfo;
  }



  public enum ENDPOINT {
    ICAO("/{icao}", "icao"),
    ;

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
