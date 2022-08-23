<script setup>
import { ref } from 'vue';

const props = defineProps({
  data: {
    type: Object,
  },
});

const emit = defineEmits('closeComponent');

const calculateNewLat = (lat, kmToAdd) => {
  const r_earth = 6378;
  return lat + (kmToAdd / r_earth) * (180 / Math.PI);
};

const calculateNewLon = (lon, lat, kmToAdd) => {
  const r_earth = 6378;
  return (
    lon +
    ((kmToAdd / r_earth) * (180 / Math.PI)) / Math.cos((lat * Math.PI) / 180)
  );
};

const openMap = () => {
  const lat = props.data.latitude;
  const lon = props.data.longitude;
  const addKm = 5;
  const posLat = calculateNewLat(lat, addKm);
  const negLat = calculateNewLat(lat, -addKm);
  const posLon = calculateNewLon(lon, lat, addKm);
  const negLon = calculateNewLon(lon, lat, -addKm);

  console.log(
    'lat,lon,posLat, posLon, negLat, negLon',
    lat,
    lon,
    posLat,
    posLon,
    negLat,
    negLon
  );
  return (
    'https://www.openstreetmap.org/export/embed.html?bbox=' +
    negLon +
    '%2C' +
    negLat +
    '%2C' +
    posLon +
    '%2C' +
    posLat +
    '&layer=mapnik&marker=' +
    lat +
    '%2C' +
    lon
  );
};

const redirectToWebsite = () => {
  location.href = props.data.website;
};

const close = () => {
  emit('closeComponent');
};
</script>

<template>
  <v-card class="card" elevation="20" shaped>
    <v-card-title class="white-text">
      {{ props.data.name }}
    </v-card-title>
    <v-container>
      <v-row>
        <v-text-field v-model="props.data.iata" label="IATA" readonly />
        <v-text-field v-model="props.data.icao" label="ICAO" readonly />
        <v-text-field v-model="props.data.code" label="Code" readonly />
      </v-row>
      <v-row>
        <v-text-field v-model="props.data.country" label="Country" readonly />
        <v-text-field
          v-model="props.data.countryIso"
          label="Country Iso"
          readonly
        />
        <v-text-field v-model="props.data.county" label="County" readonly />
      </v-row>
      <v-row>
        <v-text-field v-model="props.data.phone" label="Phone" readonly />
        <v-text-field
          v-model="props.data.postalCode"
          label="Postal Code"
          readonly
        />
        <v-text-field v-model="props.data.state" label="State" readonly />
      </v-row>
      <v-row>
        <v-text-field
          v-model="props.data.website"
          label="Website"
          readonly
          append-outer-icon="mdi-external-link"
          @click:append-outer="redirectToWebsite"
        />
      </v-row>
      <v-row>
        <iframe
          width="425"
          height="350"
          frameborder="0"
          scrolling="no"
          marginheight="0"
          marginwidth="0"
          :src="openMap()"
        ></iframe>
      </v-row>
    </v-container>
    <v-divider></v-divider>

    <v-card-actions>
      <v-btn text @click="close"> Close </v-btn>
    </v-card-actions>
  </v-card>
</template>

<style scoped>
.card {
  position: fixed;
  top: 10%;
  left: 20%;
  width: 50%;
  z-index: 999;
}

* {
  margin: 3px;
}

iframe {
  width: 100%;
}
</style>
