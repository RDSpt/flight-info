package com.challenge.flightinfo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JsonResponseBuilder<T> {

  private List<String> errors;

  private List<T> data;

  public JsonResponseBuilder<T> errors(String... errors) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }

    this.errors.addAll(Arrays.asList(errors));

    return this;
  }

  public JsonResponseBuilder<T> data(T data) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }

    this.data.add(data);

    return this;
  }

  public JsonResponseBuilder<T> data(Collection<T> data) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }

    this.data.addAll(data);

    return this;
  }

  public JsonResponse<T> build() {
    JsonResponse<T> response = new JsonResponse<>();

    if (this.errors != null) {
      response.setErrors(this.errors);
    }
    if (this.data != null) {
      response.setData(this.data);
    }

    return response;

  }

}
