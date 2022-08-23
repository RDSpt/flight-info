<script setup>
const props = defineProps({
  numberOfPlanes: {
    type: Number,
    default: 5,
  },
  numberOfRows: {
    type: Number,
    default: 2,
  },
});
const planeSrc = "src/assets/plane.png";
const planes = [];
for (let i = 0; i < props.numberOfPlanes; i++) {
  planes.push({ id: i });
}

let marginVertical = () => {
  return Math.random() * (1000 / props.numberOfRows) + "px ";
};
let marginHorizontal = () => {
  return Math.random() * 500 + "px ";
};
</script>

<template>
  <div class="container">
    <div class="sky" v-for="r in 4" :key="r">
      <div v-for="r in props.numberOfRows" :key="r" class="skyRow">
        <img
          alt=""
          v-for="plane in planes"
          :key="plane.id"
          class="plane"
          :src="planeSrc"
          :style="{
            margin: marginVertical() + marginHorizontal() + '0 0',
            padding: marginVertical() + marginHorizontal() + '0 0',
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
  overflow: hidden;
  margin: 0;
  padding: -5px;
  animation: scroll 15s linear infinite;
}

.skyRow {
  display: flex;
  flex-wrap: nowrap;
  align-items: stretch;
  width: 600px;
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
