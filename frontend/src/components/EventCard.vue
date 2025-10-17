<script setup lang="ts">
import { type Event } from '@/types'
import { RouterLink } from 'vue-router'

defineProps<{
  event: Event
}>()
</script>

<template>
  <!-- แก้ไข :to="{ name: ... }" ตรงนี้ -->
  <RouterLink class="event-link" :to="{ name: 'event-detail-view', params: { id: event.id } }">
    <div
      class="cursor-pointer border border-gray-600 p-[20px] w-[250px] mb-[18px] hover:scale-101 hover:shadow-lg transition-transform duration-200"
    >
      <h2 class="text-lg font-bold text-gray-800">{{ event.title }}</h2>
      <h5 class="text-sm text-gray-700 mb-2">by {{ event.organizer.name }}</h5>
      <span class="text-gray-600">@{{ event.time }} on {{ event.date }}</span>
    </div>
  </RouterLink>
</template>

<style scoped>
.event-link {
  text-decoration: none;
  color: #2c3e50;
}
</style>

