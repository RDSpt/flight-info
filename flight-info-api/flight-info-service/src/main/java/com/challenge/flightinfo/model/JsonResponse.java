package com.challenge.flightinfo.model;

import static com.google.common.base.MoreObjects.*;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse<T> {

  private List<String> errors = new ArrayList<>();

  private List<T> data = new ArrayList<>();


  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public void addError(String error){
    getErrors().add(error);
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public void addError(T data){
    getData().add(data);
  }

  @Override
  public String toString() {
    return toStringHelper(this).add("errors", errors).add("data", data).toString();
  }
}
