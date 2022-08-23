<script setup>
import { ref, reactive } from 'vue';
import AirportInfo from './AirportInfo.vue';
import axios from 'Axios';

const options = ['Airline', 'Airport'];
const airportInput = ref('');
const selectedOption = ref('');
const iata = ref('');
const icao = ref('');
const name = ref('');
let airports = reactive({ data: [] });
let errors = reactive({ text: '' });

const authHeader = () => {
  // return authorization header with basic auth credentials
  const encodedUserPw = 'ZmxpZ2h0aW5mbzpzaWVtZW5z';

  return { Authorization: 'Basic ' + encodedUserPw };
};

const getEndpoint = () => {
  if (selectedOption.value === 'Airline') {
    return 'https://127.0.0.1:8443/flight-info/airline'; //?searchType=NAME&value=TAP';
  } else if (selectedOption.value === 'Airport') {
    if (airportInput.value.length > 0) {
      return (
        'https://127.0.0.1:8443/flight-info/airport?airportCode=' +
        airportInput.value
      );
    }
  }
};

const submit = async () => {
  const requestOptions = {
    method: 'GET',
    headers: authHeader(),
  };

  axios.get(getEndpoint(), requestOptions).then((response) => {
    if (response.data.data[0].error) {
      errors.text = response.data.data[0].error.text;
      setTimeout(() => {
        errors.text = '';
      }, 2000);
    } else {
      airports.data = response.data.data;
    }
  });
};

const resetAirports = () => {
  airports.data = [];
};
</script>

<template>
  <div class="error-alert">
    <v-alert
      v-if="errors.text.length > 0"
      v-model="errors"
      close-text="Close Alert"
      color="red"
      dark
    >
      {{ errors.text }}
    </v-alert>
  </div>
  <!-- <v-card class="center" elevation="20" shaped> -->
  <v-container class="grey lighten-5 mb-6 center">
    <v-form ref="form">
      <v-row justify="center">
        <v-col cols="6" md="3">
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
            v-model="airportInput"
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
            @click="submit"
          >
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-form>
  </v-container>
  <!-- </v-card> -->
  <airport-info
    v-for="airport in airports.data"
    :key="airport.iata"
    :data="airport"
    @closeComponent="resetAirports"
  />
</template>

<style scoped>
.center {
  position: absolute;
  top: 50%;
  z-index: 999;
}

.error-alert {
  position: fixed;
  top: 0%;
  left: 20%;
  width: 50vw;
  z-index: 999;
}
</style>
