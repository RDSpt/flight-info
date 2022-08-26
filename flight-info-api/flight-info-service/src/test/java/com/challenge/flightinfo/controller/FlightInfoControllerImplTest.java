package com.challenge.flightinfo.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.challenge.flightinfo.business.FlightInfoService;
import com.challenge.flightinfo.business.model.AirlineInfo;
import com.challenge.flightinfo.business.model.AirportInfo;

@ExtendWith(SpringExtension.class)
public class FlightInfoControllerImplTest {

  private MockMvc mockMvc;

  @Mock
  private FlightInfoService service;

  @InjectMocks
  private FlightInfoControllerImpl instance;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(instance).build();

  }

  @Test
  void getAirportInfo() throws Exception {
    when(service.getAirportInfo(anyString())).thenReturn(new AirportInfo());
    mockMvc.perform(MockMvcRequestBuilders.get("/flight-info/airport").param("airportCode", "example"))
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void getAirlineInfo() throws Exception {
    when(service.getAirlineInfo(anyString(), anyString())).thenReturn(Collections.singletonList(new AirlineInfo()));
    mockMvc.perform(MockMvcRequestBuilders.get("/flight-info/airline").param("value", "example").param("searchType", "NAME"))
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

}
