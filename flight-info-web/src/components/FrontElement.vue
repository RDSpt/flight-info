<script setup>
import { ref } from 'vue';
import AirportInfo from './AirportInfo.vue';

const airpotCode = ref('');
const selectedOption = ref('');
const iata = ref('');
const icao = ref('');
const name = ref('');
let airport = ref('');

const authHeader = () => {
  // return authorization header with basic auth credentials
  const encodedUserPw = 'ZmxpZ2h0aW5mbzpzaWVtZW5z';

  return { Authorization: 'Basic ' + encodedUserPw };
};

const submit = () => {
  airport = [];
  let endpoint;
  if (selectedOption.value === 'Airline') {
    endpoint = 'https://127.0.0.1:8443/flight-info/airline'; //?searchType=NAME&value=TAP';
  } else if (selectedOption.value === 'Airport') {
    endpoint = 'https://127.0.0.1:8443/flight-info/airport';
    if (airpotCode.value.length > 0) {
      endpoint += '?airportCode=' + airpotCode.value;
    }
  }

  const requestOptions = {
    method: 'GET',
    headers: authHeader(),
  };
  console.log(endpoint);
  fetch(endpoint, requestOptions).then((response) => {
    response.json().then(function (data) {
      console.log(data)
      console.log(data.data)
      airport = data.data;
    });
    console.log(airport);
  });
};

// const fetchEndpoint = (endpoint) => {
//   return fetch(endpoint)
//     .then(
//     function(response) {
//         if (response.status !== 200) {
//         console.log('Looks like there was a problem. Status Code: ' +
//             response.status);
//         return;
//         }

//         // Examine the text in the response
//         response.json().then(function(data) {
//         console.log(data);
//         });
//     }
//     )
//     .catch(function(err) {
//     console.log('Fetch Error :-S', err);
//     });
// }

const options = ['Airline', 'Airport'];
</script>

<template>
  <v-container class="grey lighten-5 mb-6 center">
    <v-form ref="form">
      <v-row justify="center">
        <v-col cols="6" md="2">
          <v-select
            label="What are you searching for?"
            :items="options"
            prepend-inner-icon="{{option}}"
            v-model="selectedOption"
            solo
          ></v-select
        ></v-col>
        <v-col cols="20" md="4">
          <v-text-field
            v-if="selectedOption === 'Airport'"
            v-model="airpotCode"
            label="Please insert Aiport Code?"
            solo
          ></v-text-field>
          <v-row justify="center">
            <v-text-field
              v-if="selectedOption === 'Airline'"
              v-model="iata"
              label="IATA"
              solo
            ></v-text-field>
            <v-text-field
              v-if="selectedOption === 'Airline'"
              v-model="icao"
              label="ICAO"
              solo
            ></v-text-field>
            <v-text-field
              v-if="selectedOption === 'Airline'"
              v-model="name"
              label="NAME"
              solo
            ></v-text-field>
          </v-row>
        </v-col>
        <v-col cols="1" md="1">
          <v-btn
            v-if="selectedOption"
            class="ma-2"
            outlined
            large
            fab
            color="indigo"
            v-on:click="submit"
          >
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-form>
  </v-container>
  <airport-info v-for="a in airport.length" :key="a.iata" data="a" />
</template>

<style scoped>
.center {
  position: absolute;
  top: 50%;
  z-index: 999;
}
</style>
