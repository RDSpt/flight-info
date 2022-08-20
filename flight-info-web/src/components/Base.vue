<script setup>
defineProps({
  msg: {
    type: String,
    required: true,
  },
});
</script>

<template>
  <div class="center">
    <select name="type" id="type"></select>
    <input v-model="input" />
    <p>{{ input }}</p>
  </div>
</template>

<style scoped>
select {
  width: 100%;
}
</style>
