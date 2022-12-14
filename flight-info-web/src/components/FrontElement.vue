<script setup>
import { ref, reactive, computed } from 'vue';
import AirportInfo from './AirportInfo.vue';
import AirlineInfo from './AirlineInfo.vue';
import axios from 'redaxios';

const host = (import.meta.env.VITE_FLIGHT_INFO_API||'http://localhost:8443') + '/flight-info';
const options = ['Airline', 'Airport'];
const airportInput = ref('');
const selectedOption = ref('');
const iata = ref('');
const icao = ref('');
const name = ref('');
let airports = reactive({ data: [] });
let airlines = reactive({ data: [] });
let errors = reactive({ text: '' });
let waiting = ref(false);

const getEndpoint = () => {
  if (selectedOption.value === 'Airline') {
    if (icao.value.length > 0) {
      return host + '/airline?searchType=ICAO&value=' + icao.value;
    } else if (iata.value.length > 0) {
      return host + '/airline?searchType=IATA&value=' + iata.value;
    } else if (name.value.length > 0) {
      return host + '/airline?searchType=NAME&value=' + name.value;
    }
  } else if (selectedOption.value === 'Airport') {
    if (airportInput.value.length > 0) {
      return host + '/airport?airportCode=' + airportInput.value;
    }
  }
};

const submit = async () => {
  waiting.value = true;
  const config = {
    method: 'get',
    url: getEndpoint(),
    headers: {
      Authorization:
        'Basic ' +
        btoa(
          (import.meta.env.VITE_SECURITY_USER || 'default')+
            ':' +
            (import.meta.env.VITE_SECURITY_PW || 'pw')
        ),
    },
  };

  axios(config)
    .then((response) => {
      if (selectedOption.value === 'Airline') {
        airlineResponse(response);
      } else if (selectedOption.value === 'Airport') {
        airportResponse(response);
      }
      waiting.value = false;
    })
    .catch((err) => {
      console.log(err.response);
    });
};

const airportResponse = (response) => {
  if (response.data.data[0].error) {
    errors.text = response.data.data[0].error.text;
    setTimeout(() => {
      errors.text = '';
    }, 2000);
  } else {
    airports.data = response.data.data;
  }
};

const airlineResponse = (response) => {
  if (response.data.data[0].error) {
    errors.text = response.data.data[0].error.text;
    setTimeout(() => {
      errors.text = '';
    }, 2000);
  } else {
    airlines.data = response.data.data;
  }
};

const resetAirports = () => {
  airports.data.pop(airports.data.length - 1);
};

const resetAirlines = () => {
  airlines.data.pop(airlines.data.length - 1);
};

const iataDisabled = computed(
  () => icao.value.length > 0 || name.value.length > 0
);

const icaoDisabled = computed(
  () => iata.value.length > 0 || name.value.length > 0
);

const nameDisabled = computed(
  () => icao.value.length > 0 || iata.value.length > 0
);

const btnDisabled = computed(() => waiting.value);
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
  <v-card class="main-card" elevation="20" shaped>
    <v-form ref="form" class="form-item">
      <v-row justify="space-between">
        <v-col cols="3" align-self="center">
          <v-select
            label="What are you searching for?"
            :items="options"
            prepend-inner-icon="{{option}}"
            v-model="selectedOption"
            solo
          ></v-select
        ></v-col>
        <v-col cols="7" align-self="center">
          <v-text-field
            v-if="selectedOption === 'Airport'"
            v-model="airportInput"
            counter="3"
            clearable
            label="Please insert Aiport Code?"
            solo
          ></v-text-field>
          <v-row justify="space-between" class="airlineRow">
            <v-text-field
              class="airlineField"
              v-if="selectedOption === 'Airline'"
              v-model="iata"
              label="IATA"
              solo
              :disabled="iataDisabled"
            ></v-text-field>
            <v-text-field
              class="airlineField"
              v-if="selectedOption === 'Airline'"
              v-model="icao"
              label="ICAO"
              solo
              :disabled="icaoDisabled"
            ></v-text-field>
            <v-text-field
              class="airlineField"
              v-if="selectedOption === 'Airline'"
              v-model="name"
              label="NAME"
              solo
              :disabled="nameDisabled"
            ></v-text-field>
          </v-row>
        </v-col>
        <v-col cols="1" align-self="center">
          <v-btn
            v-if="selectedOption"
            class="ma-2"
            outlined
            large
            fab
            color="indigo"
            :disabled="btnDisabled"
            @click="submit"
          >
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-form>
  </v-card>
  <airport-info
    v-for="airport in airports.data"
    :key="airport.iata"
    :data="airport"
    @closeComponent="resetAirports"
  />
  <airline-info
    v-for="airline in airlines.data"
    :key="airline.iata"
    :data="airline"
    @closeComponent="resetAirlines"
  />
</template>

<style scoped>
.main-card {
  position: absolute;
  top: 50%;
  left: 20%;
  width: 60vw;
  z-index: 999;
  opacity: 75%;
}

.error-alert {
  position: fixed;
  top: 0%;
  left: 20%;
  width: 60vw;
  z-index: 999;
}

.v-row {
  margin: 0px;
}

.v-form {
  opacity: 100%;
}

.airlineField {
  margin: 0px 3px;
}
</style>
