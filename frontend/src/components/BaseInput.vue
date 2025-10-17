<script setup lang="ts">
const modelValue = defineModel()
interface BaseInputProps {
  label: string
}
const props = withDefaults(defineProps<BaseInputProps>(), {
  label: ''
})
</script>

<template>
  <div class="field">
    <label v-if="label">
      {{ props.label }}
    </label>
    <input class="input" v-bind="$attrs" v-model="modelValue" :placeholder="label" />
  </div>
</template>

<style scoped>
.input {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
}
.field {
    margin-bottom: 24px;
}
</style>