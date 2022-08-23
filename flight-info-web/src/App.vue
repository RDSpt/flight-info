<script setup>
import FrontElement from "./components/FrontElement.vue";
import AnimatedBackground from "./components/background/AnimatedBackground.vue";
import LogoComp from "./components/background/LogoComp.vue";
</script>

<template>
  <div class="main">
    <logo-comp />
    <animated-background />
    <front-element />
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
