<script setup>
import AnimatedSky from './AnimatedSky.vue';
import AnimatedPlane from './AnimatedPlane.vue';
</script>

<template>
  <div class="grid-animation">
    <div class="el1">
      <animated-sky :number-of-clouds="15" :number-of-rows="3" />
    </div>
    <div class="el2">
      <animated-plane :number-of-planes="5" :number-of-rows="2" />
    </div>
  </div>
</template>

<style>
.grid-animation {
  max-height: 50vw;
  display: flex;
}

.el1 .el2 {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
</style>
