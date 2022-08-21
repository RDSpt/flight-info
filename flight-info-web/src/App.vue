<script setup>
import FrontElement from "./components/FrontElement.vue";
import AnimatedBackground from "./components/AnimatedBackground.vue";
</script>

<template>
  <div class="main">
    <AnimatedBackground />
    <FrontElement />
  </div>
</template>

<style scoped>
.main {
  display: grid;
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
  position: relative;
}
</style>
