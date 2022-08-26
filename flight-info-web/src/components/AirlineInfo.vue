<script setup>
import { onMounted, computed } from 'vue';

const props = defineProps({
  data: {
    type: Object,
  },
});

const logoFolder = 'src/assets/airlineLogo/';
const imageExtension = '.png';

const airlineLogo = (manufacturer) => {
  return manufacturer ? logoFolder + manufacturer + imageExtension : '';
};

const emit = defineEmits('closeComponent');

const close = () => {
  emit('closeComponent');
};

onMounted(()=>{
  console.log(props.data.fleetInfo)
})
</script>

<template>
  <v-card class="card" elevation="20" shaped>
    <v-card-title class="white-text title">
      {{ props.data.name }}
      <img  alt="" :src="props.data.logoUrl" />
    </v-card-title>
    <v-container>
      <v-row>
        <v-text-field v-model="props.data.iata" label="IATA" readonly />
        <v-text-field v-model="props.data.icao" label="ICAO" readonly />
      </v-row>
      <v-divider></v-divider>
      <v-table height="500px">
        <thead>
          <tr>
            <th class="text-left">Logo</th>
            <th class="text-left">Manufacturer</th>
            <th class="text-left">Model</th>
            <th class="text-left"># Aircrafts</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in props.data.fleetInfo"
            :key="item.modelName"
          >
            <td>
              <img
                class="airline-logo"
                alt=""
                :src="airlineLogo(item.manufacturer)"
              />{{ item.name }}
            </td>
            <td>{{ item.manufacturer }}</td>
            <td>{{ item.modelName }}</td>
            <td>{{ item.quantity }}</td>
          </tr>
        </tbody>
      </v-table>
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

.airline-logo {
  width: 100px;
}

.title {
  display: flex;
  justify-content:space-between;
  align-items: baseline;
}
</style>
