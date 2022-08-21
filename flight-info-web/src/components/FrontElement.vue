<script setup>
import { ref } from 'vue';

const inputText = ref('');
const selectedOption = ref('');
console.log(
  'inputText: ',
  inputText.value,
  'selectedOption: ',
  selectedOption.value
);

const options = ['Airline', 'Airport', 'Flight'];
</script>

<template>
  <v-container class="center" color="blue lighten-4">
    <v-form ref="form">
      <v-row justify="center">
        <v-col cols="6" md="2">
          <v-select
            label="Select an option"
            :items="options"
            prepend-inner-icon="{{option}}"
            v-model="selectedOption"
            solo
          ></v-select
        ></v-col>
        <v-col cols="20" md="4">
          <v-text-field
            v-model="inputText"
            label="What are you searching for?"
            solo
          ></v-text-field
        ></v-col>
      </v-row>
    </v-form>
  </v-container>
</template>

<style scoped>
.center {
  position: absolute;
  top: 50%;
  z-index: 999;
}
</style>
