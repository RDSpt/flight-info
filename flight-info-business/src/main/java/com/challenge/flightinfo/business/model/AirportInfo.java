package com.challenge.flightinfo.business.model;

import com.google.common.base.MoreObjects;

public class AirportInfo {

  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("code", code).toString();
  }
}
