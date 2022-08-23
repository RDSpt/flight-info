<script setup>
const props = defineProps({
  numberOfClouds: {
    type: Number,
    default: 5,
  },
  numberOfRows: {
    type: Number,
    default: 2,
  },
});

const cloudsFolder = 'src/assets/clouds/cloud';
const imageExtension = '.png';

const randomClouds = () => {
  const cloudsObj = [];
  for (let i = 0; i < props.numberOfClouds; i++) {
    const randomId = Math.floor(Math.random() * 9);
    cloudsObj.push({ id: i, src: cloudsFolder + randomId + imageExtension });
  }
  return cloudsObj;
};

let marginVertical = () => {
  return Math.random() * 250 + 'px ';
};
let marginHorizontal = () => {
  return Math.random() * 550 + 'px ';
};
</script>

<template>
  <div class="container">
    <div class="sky" v-for="r in 4" :key="r">
      <div v-for="r in props.numberOfRows" :key="r" class="skyRow">
        <img
          alt=""
          v-for="cloud in randomClouds()"
          :key="cloud.id"
          class="cloud"
          :src="cloud.src"
          :style="{
            margin: marginVertical() + marginHorizontal() + '0 0',
          }"
        />
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
}

.sky {
  position: relative;
  width: 100vw;
  height: 100%;
  background-color: #4eadf5;
  overflow: hidden;
  margin: 0;
  padding: -5px;
}

.skyRow {
  display: flex;
  flex-wrap: nowrap;
  align-items: stretch;
}

.cloud {
  flex: 0 0 auto;
  display: flex;
  justify-content: center;
  align-self: center;
}
</style>
