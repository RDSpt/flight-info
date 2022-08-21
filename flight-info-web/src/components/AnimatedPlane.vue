<script setup>
const planeSrc = "src/assets/plane.png";
const nPlanes = 5;
const nRows = 2;
let id = 0;

let marginVertical = () => {
  return Math.random() * 1000 + "px ";
};
let marginHorizontal = () => {
  return Math.random() * 500 + 1000 + "px ";
};
</script>

<template>
  <div class="sky" v-for="r in 4" :key="r">
    <div v-for="r in nRows" :key="r" class="skyRow">
      <img
        v-for="plane in nPlanes"
        :key="id++"
        class="plane"
        :src="planeSrc"
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
  overflow: hidden;
  z-index: 10;
  margin: 0;
  padding: -5px;
  animation: scroll 15s linear infinite;
}

.skyRow {
  display: flex;
  flex-wrap: nowrap;
  align-items: stretch;
}

.plane {
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
    transform: translateX(-110vw);
  }
}
</style>
