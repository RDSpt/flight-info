# Flight-Info

This webapp is currently deployend in Heroky: https://flight-info-web.herokuapp.com/

## Introduction

The intended challenged was to create a web application, using preferable Vue.Js Frontend and Java Backend. The application would have to access an external API
and model a use it.
This webapp gathers information from 3 external API and displays in an appealing view the information gathered.

## Technical info

### Frontend
Vue 3 (Compositon API)

Vite

Veutify

### Backend
Java 11

Spring Boot

### Deployment
Heroku

| HTTP METHOD | PATH | PARAMETER                 | USAGE                    | EXAMPLE |
| -----------| ------ |---------------------------|--------------------------|---------|
| GET | /flight-info/airport |airportCode| Get Airport info from airport code |/flight-info/airport?airportCode=opo       | 
| GET | /flight-info/airline | value & searchType| Get Airline Info from Name, Iata code or Icao Code    |  /flight-info/airline?searchType=NAME&value=tap     |
