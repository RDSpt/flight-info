<script setup>
const cloudsFolder = "src/assets/clouds/cloud";
const imageExtension = ".png";
const nClouds = 15;
const nRows = 5;

const randomClouds = () => {
  const cloudsObj = [];
  for (let i = 0; i < nClouds; i++) {
    const randomId = Math.floor(Math.random() * 9);
    cloudsObj.push({ id: i, src: cloudsFolder + randomId + imageExtension });
  }
  return cloudsObj;
};

let marginVertical = () => {
  return Math.random() * 250 + "px ";
};
let marginHorizontal = () => {
  return Math.random() * 550 + "px ";
};
</script>

<template>
  <div class="sky" v-for="r in 4" :key="r">
    <div v-for="r in nRows" :key="r" class="skyRow">
      <img
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
</template>

<style scoped>
.sky {
  position: relative;
  width: 100vw;
  height: 100%;
  background-color: #4eadf5;
  overflow: hidden;
  z-index: 1;
  margin: 0;
  padding: -5px;
  animation: scroll 60s linear infinite;
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

@keyframes scroll {
  from {
    transform: translateX(0);
  }
  to {
    transform: translateX(-100vw);
  }
}
</style>
