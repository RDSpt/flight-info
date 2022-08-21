package com.challenge.flightinfo.business.model;

import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class AirlineInfo {

  private String iata;

  private String icao;

  @SerializedName("logo_url")
  private String logoUrl;
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


  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
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
      .add("logo_url", logoUrl)
      .add("name", name)
      .add("fleet", fleet)
      .toString();
  }
}
