package com.challenge.flightinfo.business.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.flightinfo.business.model.AirlineInfo;
import com.google.gson.Gson;

@Component
public class AirlineApi extends ApiIntegration {

  private static final String URL = "https://airlines-by-api-ninjas.p.rapidapi.com/v1";

  public AirlineApi() {
    super(URL);
    addHeader("X-RapidAPI-Key", "31134d3e19msh48e6b2f4e6d24e9p105587jsn337210ed41a0");
    addHeader("'X-RapidAPI-Host", "airlines-by-api-ninjas.p.rapidapi.com");
  }

  public List<AirlineInfo> getAirlineByName(String name) {
    HashMap<String, String> parameters = new HashMap<>();
    parameters.put(ENDPOINT.AIRLINE_NAME.getParameters()[0], name);

    String jsonResponse = get(ENDPOINT.AIRLINE_NAME.getEndpointUrl(), parameters);
    AirlineInfo[] airlinesList= new Gson().fromJson(jsonResponse, AirlineInfo[].class);

    return Arrays.asList(airlinesList);
  }

  public List<AirlineInfo> getAirlineByIcao(String icao) {
    HashMap<String, String> parameters = new HashMap<>();
    parameters.put(ENDPOINT.AIRLINE_NAME.getParameters()[0], icao);

    String jsonResponse = get(ENDPOINT.AIRLINE_ICAO.getEndpointUrl(), parameters);
    AirlineInfo[] airlinesList= new Gson().fromJson(jsonResponse, AirlineInfo[].class);

    return Arrays.asList(airlinesList);
  }

  public List<AirlineInfo> getAirlineByIata(String iata) {
    HashMap<String, String> parameters = new HashMap<>();
    parameters.put(ENDPOINT.AIRLINE_NAME.getParameters()[0], iata);

    String jsonResponse = get(ENDPOINT.AIRLINE_IATA.getEndpointUrl(), parameters);
    AirlineInfo[] airlinesList= new Gson().fromJson(jsonResponse, AirlineInfo[].class);

    return Arrays.asList(airlinesList);
  }

  public enum ENDPOINT {

    AIRLINE_NAME("/airlines?name={name}", "name"),
    AIRLINE_ICAO("/airlines?icao={icao}", "icao"),
    AIRLINE_IATA("/airlines?iata={iata}", "iata"),
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
