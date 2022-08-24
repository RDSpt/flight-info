package com.challenge.flightinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightInfoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FlightInfoApplication.class, args);
	}

}
