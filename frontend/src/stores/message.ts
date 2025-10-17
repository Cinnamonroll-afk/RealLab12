import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useMessageStore = defineStore('message', () => {
  const message = ref<string>('')

  function updateMessage(newMessage: string) {
    message.value = newMessage
  }

  function resetMessage() {
    message.value = ''
  }

  return { message, updateMessage, resetMessage }
})