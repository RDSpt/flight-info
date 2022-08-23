<script setup>
const props = defineProps({
  data: {
    type: Object,
  },
});

/*

city: ""
code: null
country: "Canada"
countryIso: "CA"
county: "Montreal"
iata: "YUL"
icao: "CYUL"
latitude: 45.465687
location: "Montreal, Quebec, Canada"
longitude: -73.74548
name: "Montréal–Pierre Elliott Trudeau International Airport"
phone: "+1 514-394-7377"
postalCode: ""
state: "Quebec"
street: ""
streetNumber: ""
uct: -240
website: "http://www.admtl.com/"
*/

const openMap = () => {
  const lat = props.data.latitude;
  const lon = props.data.longitude;
  const r_earth = 6378;
  const new_latitude = lat + (10 / r_earth) * (180 / Math.pi);
  const new_longitude =
    lon + ((10 / r_earth) * (180 / Math.pi)) / Math.cos((lat * Math.pi) / 180);
  return (
    'https://www.openstreetmap.org/export/embed.html?bbox=' +
    lon +
    '%2C' +
    lat +
    '%2C' +
    new_longitude +
    '%2C' +
    new_latitude +
    '&amp;layer=mapnik&amp;marker=' +
    lon +
    '%2C' +
    lat
  );
};
</script>

<template>
  <v-card elevation="20" shaped>
    <v-card-text class="white--text">
      {{ props.data.name }}
    </v-card-text>
    <v-container>
      <v-row>
        <v-col>
          <v-text-field
            :value="props.data.iata"
            label="IATA"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.icao"
            label="ICAO"
            readonly
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-text-field
            :value="props.data.code"
            label="Code"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.country"
            label="Country"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.countryIso"
            label="Country Iso"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.county"
            label="County"
            readonly
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-text-field
            :value="props.data.phone"
            label="Phone"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.postalCode"
            label="Postal Code"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.state"
            label="State"
            readonly
          ></v-text-field>
          <v-text-field
            :value="props.data.website"
            label="Website"
            readonly
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <iframe
            width="425"
            height="350"
            frameborder="0"
            scrolling="no"
            marginheight="0"
            marginwidth="0"
            :src="openMap"
          ></iframe>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<style scoped></style>
