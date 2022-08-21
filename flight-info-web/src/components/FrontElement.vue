<script setup>
import { ref } from "vue";

const inputText = ref("");

const options = [
  { id: 1, value: "Airline" },
  { id: 2, value: "Airport" },
  { id: 3, value: "Flight" },
];
</script>

<template>
  <div class="center">
    <select name="type" id="type">
      <option v-for="option in options" :key="option.id" value="{option.value}">
        {{ option.value }}
      </option>
    </select>
    <input v-model="inputText" placeholder="What are you searching for?" />
  </div>
</template>

<style scoped>
.center {
  margin: 0% 5%;
  z-index: 2;
}
select {
  width: 50%;
}
input {
  width: 50%;
}
</style>
