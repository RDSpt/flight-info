package com.challenge.flightinfo.business.model;

import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;

public class AirlineInfo {

  private String iata;

  private String icao;

  private String logo_url;
  private String name;
  private Map<String, Long> fleet;

  public String getIata() {
    return iata;
  }

  public void setIata(String iata) {
    this.iata = iata;
  }

  public String getIcao() {
    return icao;
  }

  public void setIcao(String icao) {
    this.icao = icao;
  }

  public String getLogo_url() {
    return logo_url;
  }

  public void setLogo_url(String logo_url) {
    this.logo_url = logo_url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Long> getFleet() {
    return fleet;
  }

  public void setFleet(Map<String, Long> fleet) {
    this.fleet = fleet;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add("iata", iata)
      .add("icao", icao)
      .add("logo_url", logo_url)
      .add("name", name)
      .add("fleet", fleet)
      .toString();
  }
}
