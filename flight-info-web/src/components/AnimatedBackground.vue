<script setup>
import AnimatedSky from './AnimatedSky.vue';
import AnimatedPlane from './AnimatedPlane.vue';
</script>

<template>
  <div class="grid-animation">
    <animated-sky />
    <animated-plane />
  </div>
</template>

<style>
.grid-animation {
  display: flex;
}

animated-sky {
  position: absolute;
  left: 0px;
  top: 0px;
  z-index: 1;
}

animated-plane {
  position: absolute;
  left: 0px;
  top: 0px;
  z-index: 2;
}
</style>
