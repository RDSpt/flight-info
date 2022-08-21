package com.challenge.flightinfo.business.model;

import java.math.BigDecimal;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class AirportInfo {

  private String code;

  private String iata;
  private String icao;
  private String name;
  private String location;

  @SerializedName("street_number")
  private String streetNumber;
  private String street;
  private String city;
  private String county;
  private String state;

  @SerializedName("country_iso")
  private String countryIso;
  private String country;

  @SerializedName("postal_code")
  private String postalCode;
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

  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
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

  public String getCountryIso() {
    return countryIso;
  }

  public void setCountryIso(String countryIso) {
    this.countryIso = countryIso;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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
      .add("street_number", streetNumber)
      .add("street", street)
      .add("city", city)
      .add("county", county)
      .add("state", state)
      .add("country_iso", countryIso)
      .add("country", country)
      .add("postal_code", postalCode)
      .add("phone", phone)
      .add("latitude", latitude)
      .add("longitude", longitude)
      .add("uct", uct)
      .add("website", website)
      .toString();
  }
}
