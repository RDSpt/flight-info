<script setup>
import AnimatedSky from "./AnimatedSky.vue";
import AnimatedPlane from "./AnimatedPlane.vue";
</script>

<template>
  <div class="grid-animation">
    <div class="el1">
      <animated-sky :number-of-clouds="15" :number-of-rows="6" />
    </div>
    <div class="el2">
      <animated-plane :number-of-planes="1" :number-of-rows="1" />
    </div>
  </div>
</template>

<style>
.grid-animation {
  max-height: 50vw;
  display: flex;
  animation: scroll 60s linear infinite;
  position: relative;
}

.el1 {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.el2 {
  z-index: 90;
  width: 100%;
  height: 100%;
  position: relative;
  top: 0;
  left: 0;
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
