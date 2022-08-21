<script setup>
const logoSrc = 'src/assets/flightinfo-logo.png';
</script>

<template>
  <img alt="" :src="logoSrc" />
</template>

<style scoped>
img {
  position: absolute;
  z-index: 999;
  top: 0;
  left: 0;
  width: auto;
  height: auto;
  margin: 20px;
}
</style>
