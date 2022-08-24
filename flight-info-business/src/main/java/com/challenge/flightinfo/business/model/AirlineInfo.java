package com.challenge.flightinfo.business.model;

import java.util.ArrayList;
import java.util.List;
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
  private List<AircraftInfo> fleetInfo;

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

  public List<AircraftInfo> getFleetInfo() {
    return fleetInfo;
  }

  public void setFleetInfo(List<AircraftInfo> fleetInfo) {
    this.fleetInfo = fleetInfo;
  }

  public void addFleetInfo(AircraftInfo fleetInfo) {
    if(this.fleetInfo == null) {
      this.fleetInfo = new ArrayList<>();
    }
    this.fleetInfo.add(fleetInfo);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add("iata", iata)
      .add("icao", icao)
      .add("logoUrl", logoUrl)
      .add("name", name)
      .add("fleet", fleet)
      .add("fleetInfo", fleetInfo)
      .toString();
  }
}
