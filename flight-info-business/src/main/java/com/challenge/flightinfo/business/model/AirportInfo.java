package com.challenge.flightinfo.business.model;

import java.math.BigDecimal;

import com.google.common.base.MoreObjects;

public class AirportInfo {

  private String code;

  private String iata;
  private String icao;
  private String name;
  private String location;
  private String street_number;
  private String street;
  private String city;
  private String county;
  private String state;
  private String country_iso;
  private String country;
  private String postal_code;
  private String phone;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private Long uct;
  private String website;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStreet_number() {
    return street_number;
  }

  public void setStreet_number(String street_number) {
    this.street_number = street_number;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry_iso() {
    return country_iso;
  }

  public void setCountry_iso(String country_iso) {
    this.country_iso = country_iso;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostal_code() {
    return postal_code;
  }

  public void setPostal_code(String postal_code) {
    this.postal_code = postal_code;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public Long getUct() {
    return uct;
  }

  public void setUct(Long uct) {
    this.uct = uct;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add("code", code)
      .add("iata", iata)
      .add("icao", icao)
      .add("name", name)
      .add("location", location)
      .add("street_number", street_number)
      .add("street", street)
      .add("city", city)
      .add("county", county)
      .add("state", state)
      .add("country_iso", country_iso)
      .add("country", country)
      .add("postal_code", postal_code)
      .add("phone", phone)
      .add("latitude", latitude)
      .add("longitude", longitude)
      .add("uct", uct)
      .add("website", website)
      .toString();
  }
}
