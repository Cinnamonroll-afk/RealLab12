<script setup lang="ts">
import type { Participant } from '@/type'
import { ref, onMounted } from 'vue'
import ParticipantService from '@/services/ParticipantService'
import { useRouter } from 'vue-router'

const participants = ref<Participant[]>([])
const router = useRouter() // Use router for navigation on error

onMounted(() => {
  ParticipantService.getParticipants()
    .then((response) => {
      participants.value = response.data
    })
    .catch((err) => {
      console.log(err)
      // Redirect to network error page if the API call fails
      router.push({ name: 'network-error' })
    })
})
</script>

<template>
  <div class="p-4 md:p-8 bg-gray-50 min-h-screen">
    <h1 class="text-3xl font-bold mb-6 text-gray-800 border-b pb-2">Participants</h1>
    <div class="grid gap-4 md:grid-cols-2 lg:grid-cols-3">
      <div
        v-for="p in participants"
        :key="p.id"
        class="border rounded-lg p-5 shadow-md bg-white hover:shadow-lg transition-shadow duration-300"
      >
        <h2 class="text-2xl font-semibold text-blue-600">{{ p.name }}</h2>
        <p class="text-gray-600 mt-1">Tel: {{ p.telNo }}</p>
        <div v-if="p.eventHistory && p.eventHistory.length > 0" class="mt-4 pt-3 border-t">
          <h3 class="font-bold text-gray-700">Attended Events:</h3>
          <ul class="list-disc list-inside mt-2 text-gray-600 space-y-1">
            <li v-for="event in p.eventHistory" :key="event.id">
              {{ event.title }}
            </li>
          </ul>
        </div>
         <div v-else class="mt-4 pt-3 border-t">
            <p class="text-gray-500 italic">No attended events.</p>
        </div>
      </div>
    </div>
  </div>
</template>
