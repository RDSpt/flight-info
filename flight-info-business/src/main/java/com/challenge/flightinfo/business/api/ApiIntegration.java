package com.challenge.flightinfo.business.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class ApiIntegration {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiIntegration.class);

  private final String url;
  private Map<String, String> headers;

  public ApiIntegration(String url) {
    this.url = url;
  }

  public String get() {
    return get("", null);
  }

  public String get(String endpoint, Map<String, String> parameters) {

    String finalUrl = url + endpoint;
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<String> requestEntity = null;

    if (parameters == null) {
      parameters = new HashMap<>();
    }

    if (!headers.isEmpty()) {
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setContentType(MediaType.APPLICATION_JSON);

      for (String header : headers.keySet()) {
        httpHeaders.add(header, headers.get(header));
      }

      requestEntity = new HttpEntity<>("body", httpHeaders);
    }

    LOGGER.info("Attempting to connect to {} with parameters {}", finalUrl, parameters);

    ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.GET, requestEntity, String.class, parameters);

    if (HttpStatus.OK.equals(response.getStatusCode()) && response.hasBody()) {
      String body = response.getBody();
      LOGGER.info("Response successfully retrieved, {}", body);
      return body;
    }
    LOGGER.warn("No response retrieved!");
    return null;
  }

  public void addHeader(String header, String value) {
    if (this.headers == null) {
      this.headers = new HashMap<>();
    }
    this.headers.put(header, value);
  }
}
