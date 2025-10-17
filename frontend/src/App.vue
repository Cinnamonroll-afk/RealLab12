<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import { useMessageStore } from '@/stores/message'
import { storeToRefs } from 'pinia'
const store = useMessageStore()
const { message } = storeToRefs(store)
</script>

<template>
  <div class="min-h-screen bg-gray-100 font-sans antialiased">
    <header class="bg-white shadow">
      <!-- Flash Message -->
      <div id="flashMessage" v-if="message" class="animate-flash-fade">
        <h4>{{ message }}</h4>
      </div>
      <!-- Navigation Bar -->
      <nav class="container mx-auto px-6 py-4 flex justify-center items-center space-x-4">
        <RouterLink
          class="nav-link"
          active-class="text-green-500"
          :to="{ name: 'event-list-view' }"
          >Events</RouterLink
        >
        <span class="text-gray-300">|</span>
        <RouterLink class="nav-link" active-class="text-green-500" :to="{ name: 'participant-list-view' }"
          >Participants</RouterLink
        >
        <span class="text-gray-300">|</span>
        <RouterLink class="nav-link" active-class="text-green-500" :to="{ name: 'add-event' }"
          >New Event</RouterLink
        >
        <span class="text-gray-300">|</span>
        <RouterLink class="nav-link" active-class="text-green-500" :to="{ name: 'add-organizer' }"
          >New Organizer</RouterLink
        >
        <span class="text-gray-300">|</span>
        <RouterLink class="nav-link" active-class="text-green-500" :to="{ name: 'about' }"
          >About</RouterLink
        >
      </nav>
    </header>

    <!-- Main Content -->
    <main>
      <RouterView />
    </main>
  </div>
</template>

<style>
/* Base styling for navigation links */
.nav-link {
  @apply font-bold text-gray-700 transition-colors duration-300 hover:text-green-500;
}

/* Styling for the flash message */
#flashMessage {
  @apply bg-yellow-300 text-yellow-800 p-3 text-center w-full;
  animation: flash-fade 3s ease-in-out forwards;
}

@keyframes flash-fade {
  0% {
    background-color: #fefcbf; /* Lighter yellow */
    opacity: 1;
  }
  90% {
    background-color: #fefcbf;
    opacity: 1;
  }
  100% {
    background-color: transparent;
    opacity: 0;
  }
}

/* NProgress bar styling */
#nprogress .bar {
  background: #42b983 !important;
  height: 3px !important;
}
</style>

