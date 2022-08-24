package com.challenge.flightinfo.business.model;

import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class AircraftInfo {

  private String code;
  private String manufacturer;
  private String modelName;
  private String uld320Capable;
  private String wideBody;

  private Long quantity;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getUld320Capable() {
    return uld320Capable;
  }

  public void setUld320Capable(String uld320Capable) {
    this.uld320Capable = uld320Capable;
  }

  public String getWideBody() {
    return wideBody;
  }

  public void setWideBody(String wideBody) {
    this.wideBody = wideBody;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add("code", code)
      .add("manufacturer", manufacturer)
      .add("modelName", modelName)
      .add("uld320Capable", uld320Capable)
      .add("wideBody", wideBody)
      .add("quantity", quantity)
      .toString();
  }
}
